package org.joinfaces.example.application.jsf.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Component
@Scope(ScopeTypes.VIEW)
public class ViewTestBean implements Serializable {

    @Getter
    @Setter
    private List<Integer> numbers;

    @Getter
    @Setter
    private Integer auxNumber;

    @Getter
    @Setter
    private Integer result;

    @PostConstruct
    public void init() {
        this.numbers = new ArrayList<>();
        this.auxNumber = null;
        this.result = 0;
    }

    public void addNumber() {
        this.numbers.add(auxNumber);
        this.result = this.numbers.stream().reduce(0, (n1, n2) -> n1 + n2);
        this.auxNumber = null;
    }

}
