package io.renren.modules.app.entity;

/*{
	'log_id': 3980279654413086667,
	'text': '基于统考计算机系统的研究',
	'ppl': 224.359
}*/
public class PaperTopicEntity {
    private long log_id;
    private String text;
    private Double ppl;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getPpl() {
        return ppl;
    }

    public void setPpl(Double ppl) {
        this.ppl = ppl;
    }

    @Override
    public String toString() {
        return "PaperTopicEntity{" +
                "log_id=" + log_id +
                ", text='" + text + '\'' +
                ", ppl=" + ppl +
                '}';
    }
}
