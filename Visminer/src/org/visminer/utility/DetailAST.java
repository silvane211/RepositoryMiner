package org.visminer.utility;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * The utility class to create AST from source code
 * 
 * @author felipe
 */
public class DetailAST {

    private CompilationUnit root = null;
    
    private String source;
    
    /**
     * Create a AST from a String
     * 
     * @param source the source
     */
    public void parserFromString(String source){
        this.source = source;
        setRoot(source);
    }
    
    public void partserFromBytes(byte[] bytes){
    	String str = new String(bytes);
    	setRoot(str);
    }
    
    /**
     * @param source the new root
     */
    private void setRoot(String source){
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(source.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setBindingsRecovery(true);
        
        root = (CompilationUnit) parser.createAST(null);
        
    }

    /**
     * @return source code used to generate the AST
     */
    public String getSource(){
        
        return this.source;
        
    }
    
    /**
     * @return the AST parent's node
     */
    public CompilationUnit getRoot(){

    	return this.root;
        
    }
    
}