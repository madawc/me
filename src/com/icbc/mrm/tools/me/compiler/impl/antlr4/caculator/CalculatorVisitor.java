package com.icbc.mrm.tools.me.compiler.impl.antlr4.caculator;
// Generated from Calculator.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull CalculatorParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyingExpression(@NotNull CalculatorParser.MultiplyingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parents}
	 * labeled alternative in {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParents(@NotNull CalculatorParser.ParentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#powExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpression(@NotNull CalculatorParser.PowExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#relop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(@NotNull CalculatorParser.RelopContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#scientific}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScientific(@NotNull CalculatorParser.ScientificContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull CalculatorParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(@NotNull CalculatorParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sci}
	 * labeled alternative in {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSci(@NotNull CalculatorParser.SciContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#funcname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncname(@NotNull CalculatorParser.FuncnameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function}
	 * labeled alternative in {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull CalculatorParser.FunctionContext ctx);
}