# universalimageloaderDemo
This is a demo of universalimageloader and listview

Use Application to store the ImageLoader,instead of store it as a static variable in MainActiviy.
So you can use is in the whole Applcation conveniently.
I met some bug when I develop the demo.
Such as not set the right arraylist in MainActiviy.
So the Result is that there were nothing in the listview because of the empty arraylist.

Besides this,I met a another bug.The textview is OK but the imageview is not displayed correctly.
I found that,when I  set    viewHolder.imageView = ...

I wrote  viewHolder.imageView = (ImageView) arg1.findViewById(R.id.iamge);
the right is:  viewHolder.imageView = (ImageView) arg1.findViewById(R.id.imageview);
So I must be more carefully in the future.

I hope you can understand above words.
My English is not good enough.
