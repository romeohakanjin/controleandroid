package com.example.sindy.controleevaluationm1;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sindy.controleevaluationm1.adapter.FavoriteQuestionAdapter;
import com.example.sindy.controleevaluationm1.adapter.QuestionAdapter;
import com.example.sindy.controleevaluationm1.adapter.UserAdapter;
import com.example.sindy.controleevaluationm1.database.AppDatabase;
import com.example.sindy.controleevaluationm1.database.FavoriteQuestionEntity;
import com.example.sindy.controleevaluationm1.model.FavoriteQuestion;
import com.example.sindy.controleevaluationm1.model.Question;
import com.example.sindy.controleevaluationm1.model.User;
import com.example.sindy.controleevaluationm1.retrofitquestion.Item;
import com.example.sindy.controleevaluationm1.retrofitquestion.QuestionServiceInterface;
import com.example.sindy.controleevaluationm1.retrofitquestion.RetrofitClient;
import com.example.sindy.controleevaluationm1.retrofitquestion.StackExchange;
import com.example.sindy.controleevaluationm1.retrofittopuser.TopUsers;
import com.example.sindy.controleevaluationm1.retrofittopuser.UserServiceInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getDatabase(getApplicationContext());
        mDrawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        changeFragment(new FragmentHello());

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.nav_questions :
                                QuestionServiceInterface qService = RetrofitClient.getClient().create(QuestionServiceInterface.class);
                                qService.superStackExchange().enqueue(new Callback<StackExchange>() {
                                    @Override
                                    public void onResponse(Call<StackExchange> call, Response<StackExchange> response) {
                                        if(response.isSuccessful()){
                                            ArrayList<Question> questions = new ArrayList<>();
                                            RecyclerView recyclerViewQ = findViewById(R.id.recyclerView);
                                            String titre, date;
                                            int photo;
                                            long id;

                                            for (com.example.sindy.controleevaluationm1.retrofitquestion.Item item : response.body().getItems()){
                                                id = item.getQuestionId();
                                                titre = item.getTitle();
                                                date = item.getCreationDate().toString();
                                                //photo = item.getOwner().getProfileImage()
                                                photo = R.drawable.asking;

                                                Question question = new Question(titre, date, photo, id);
                                                questions.add(question);
                                            }

                                            QuestionAdapter adapterQ = new QuestionAdapter(questions);
                                            recyclerViewQ.setAdapter(adapterQ);
                                            }
                                    }

                                    @Override
                                    public void onFailure(Call<StackExchange> call, Throwable t) {

                                    }
                                });

                                changeFragment(new FragmentQuestions());

                                break;
                            case R.id.nav_users:
                                UserServiceInterface qServiceUser = RetrofitClient.getClient().create(UserServiceInterface.class);
                                qServiceUser.superStackExchange().enqueue(new Callback<TopUsers>() {
                                    @Override
                                    public void onResponse(Call<TopUsers> call, Response<TopUsers> response) {
                                        if(response.isSuccessful()){
                                            ArrayList<User> users = new ArrayList<>();
                                            RecyclerView recyclerViewQ = findViewById(R.id.recyclerView);
                                            String name;
                                            int photo, points;

                                            for (com.example.sindy.controleevaluationm1.retrofittopuser.Item owner : response.body().getItems()){
                                                name = owner.getDisplayName();
                                                points = owner.getReputation();
                                                //photo =
                                                photo = R.drawable.group;

                                                User user = new User(name, points, photo);
                                                users.add(user);
                                            }

                                            UserAdapter adapterU = new UserAdapter(users);
                                            recyclerViewQ.setAdapter(adapterU);
                                         }
                                    }

                                    @Override
                                    public void onFailure(Call<TopUsers> call, Throwable t) {

                                    }
                                });
                                changeFragment(new FragmentUsers());
                                break;
                            case R.id.nav_favorite_questions:
                                RecyclerView recyclerViewFQ = findViewById(R.id.recyclerView);
                                List<FavoriteQuestionEntity> favoriteQuestionEntities = db.FavoriteQuestionDao().getFavoriteQuestions();
                                ArrayList<FavoriteQuestion> favoriteQuestions = new ArrayList<FavoriteQuestion>();
                                for(FavoriteQuestionEntity favoriteQuestionEntity: favoriteQuestionEntities){
                                    favoriteQuestions.add(new FavoriteQuestion(favoriteQuestionEntity.getTitre(), favoriteQuestionEntity.getDate(),
                                            favoriteQuestionEntity.getProfil(), favoriteQuestionEntity.getId()));
                                }
                                FavoriteQuestionAdapter adapterFQ = new FavoriteQuestionAdapter(favoriteQuestions);
                                recyclerViewFQ.setAdapter(adapterFQ);
                                changeFragment(new FragmentFavoriteQuestions());

                                break;
                            default:
                                break;
                        }
                        mDrawerLayout.closeDrawer(GravityCompat.START);

                        return true;
                    }
                });

    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Change le fragment qui est affiché par celui passé en paramètre
     * @param fragment
     */
    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment).commit();
    }

}