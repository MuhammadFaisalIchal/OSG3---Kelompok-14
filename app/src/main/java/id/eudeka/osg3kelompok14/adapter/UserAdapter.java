package id.eudeka.osg3kelompok14.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.eudeka.osg3kelompok14.R;
import id.eudeka.osg3kelompok14.model.UserDataRespon;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<UserDataRespon> listUser;
    private OnItemClickListener clickListener;

    public UserAdapter(List<UserDataRespon> listUser) {
        this.listUser = listUser;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        clickListener = listener;
    }

    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_row, viewGroup, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int position) {

        UserDataRespon data = listUser.get(position);
        userViewHolder.txtFirstNameUser.setText(data.getFirstName());
        Picasso.get().load(data.getAvatar()).into(userViewHolder.imgUser);

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView txtFirstNameUser;
        ImageView imgUser;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFirstNameUser = itemView.findViewById(R.id.txt_item_first_name);
            imgUser = itemView.findViewById(R.id.img_item_user);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            clickListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
