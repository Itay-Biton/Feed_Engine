package com.my_instagram;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

    public class CreateNewPostActivity extends AppCompatActivity {

        private EditText inputTitle;
        private EditText inputDescription;
        private ImageView imagePreview;
        private int selectedImageRes = R.drawable.ic_launcher_background;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_create_new_post);

            inputTitle = findViewById(R.id.input_title);
            inputDescription = findViewById(R.id.input_description);
            imagePreview = findViewById(R.id.image_preview);
            Button btnSelectImage = findViewById(R.id.btn_select_image);
            Button btnCreatePost = findViewById(R.id.btn_create_post);

            btnSelectImage.setOnClickListener(v -> {
                selectedImageRes = (selectedImageRes == R.drawable.ic_launcher_background)
                        ? R.drawable.ic_launcher_foreground
                        : R.drawable.ic_launcher_background;
                imagePreview.setImageResource(selectedImageRes);
            });

            btnCreatePost.setOnClickListener(v -> {
                String title = inputTitle.getText().toString().trim();
                String desc = inputDescription.getText().toString().trim();

                Post post = new Post(
                        String.valueOf(System.currentTimeMillis()),
                        title,
                        desc,
                        selectedImageRes
                );

                InstagramFeedActivity.addPost(post);
                finish();
            });
        }
    }