package pl.hetman.wiktoria.spring.learn.app.jellybeans;

//@Component
public class JellyBeanMapper {
    private boolean debug;

    public JellyBeanMapper(boolean debug) {
        this.debug = debug;
    }

    public JellyBeanModel from(JellyBeanModel jellyBean) {
        return new JellyBeanModel();
    }
}
