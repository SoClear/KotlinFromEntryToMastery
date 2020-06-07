public interface onClickListener {
    default void onTouch(){
        System.out.println("onTouch");
    }

    void onClick();
}
