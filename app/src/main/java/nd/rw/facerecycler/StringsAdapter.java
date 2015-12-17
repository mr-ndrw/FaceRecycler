package nd.rw.facerecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StringsAdapter extends RecyclerView.Adapter<StringsAdapter.StringViewHolder>{

    private List<String> stringList = new LinkedList<>();

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public StringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_string, parent, false);
        StringViewHolder stringViewHolder = new StringViewHolder(view);
        return stringViewHolder;
    }

    @Override
    public void onBindViewHolder(StringViewHolder holder, int position) {
        String stringAtPos = stringList.get(position);
        holder.bind(stringAtPos);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class StringViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.string)
        public TextView tv_string;

        public StringViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(String string){
            tv_string.setText(string);
        }
    }
}
