package nd.rw.facerecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recycler_view)
    public RecyclerView recyclerView;
    public StringsAdapter adapter;
    private List<String> stringList;

    @Bind(R.id.delete_top)
    public Button delete_top;
    @Bind(R.id.delete_random)
    public Button delete_random;
    @Bind(R.id.add_top)
    public Button add_top;
    @Bind(R.id.add_random)
    public Button add_random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new StringsAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL_LIST));
        String[] strings = getResources().getStringArray(R.array.strings);
        stringList = new ArrayList<>(Arrays.asList(strings));
        adapter.setStringList(stringList);
        add_random.setOnClickListener(addRandomListener);
        add_top.setOnClickListener(addTopListener);
        delete_random.setOnClickListener(deleteRandomListener);
        delete_top.setOnClickListener(deleteTopListener);
    }

    private View.OnClickListener addTopListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            stringList.add(0, "App" + (stringList.size()+1));
            adapter.notifyDataSetChanged();
        }
    };

    private View.OnClickListener addRandomListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int random = new Random().nextInt(stringList.size());
            stringList.add(random, "App" + (stringList.size()+1));
            adapter.notifyDataSetChanged();
        }
    };

    private View.OnClickListener deleteTopListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            stringList.remove(0);
            adapter.notifyDataSetChanged();
        }
    };

    private View.OnClickListener deleteRandomListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int random = new Random().nextInt(stringList.size());
            stringList.remove(random);
            adapter.notifyDataSetChanged();
        }
    };

}
