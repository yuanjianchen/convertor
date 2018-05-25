package;

<#list class.imports as package>
import ${package};
import ${package};
</#list>

public class ${class.className}{
<#list class.fields as field>
    /**
     * ${field.annation!}
     */
    @JsonProperty("${field.originalName}")
    private ${field.type} ${field.name};
</#list>
<#list class.fields as field >

    public ${field.type} get${field.name?cap_first}(){
        return ${field.name};
    }

    public void set${field.name?cap_first}(${field.type} ${field.name}){
        this.${field.name} = ${field.name};
    }
</#list>
    @Override
    public String toString() {
        return "${class.className}{" +
<#list class.fields as field >
            "${field.name}='" + ${field.name} + '\'' +
</#list>
            '}';
    }
<#list class.innerClasses as innerClass>
    public static class ${innerClass.className}{
    <#list innerClass.fields as field>
        /**
         * ${field.annation!}
         */
        @JsonProperty("${field.originalName}")
        private ${field.type} ${field.name};
    </#list>
    <#list innerClass.fields as field >

        public ${field.type} get${field.name?cap_first}(){
            return ${field.name};
        }
        public void set${field.name?cap_first}(${field.type} ${field.name}){
            this.${field.name} = ${field.name};
        }
    </#list>
        @Override
        public String toString() {
            return "${innerClass.className}{" +
        <#list innerClass.fields as field >
                "${field.name}='" + ${field.name} + '\'' +
        </#list>
                '}';
        }
    }
</#list>
}
