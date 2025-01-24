Function render294%()
    Local local0#
    Local local1#
    Local local2%
    Local local3%
    Local local4%
    showpointer()
    local0 = (Float (mo\Field9 - (imagewidth(t\Field1[$05]) Sar $01)))
    local1 = (Float (mo\Field10 - (imageheight(t\Field1[$05]) Sar $01)))
    drawblock(t\Field1[$05], (Int local0), (Int local1), $00)
    rendercursor()
    local4 = (playerroom\Field9 = $00)
    textex((Int ((905.0 * menuscale) + local0)), (Int ((185.0 * menuscale) + local1)), right(i_294\Field1, $0D), $01, $01)
    If (local4 <> 0) Then
        If ((mo\Field1 Lor (i_294\Field0 = $00)) <> 0) Then
            hidepointer()
        EndIf
    ElseIf (channelplaying(playerroom\Field9) = $00) Then
        If (i_294\Field1 <> getlocalstring("misc", "ofr")) Then
            hidepointer()
        EndIf
    EndIf
    Return $00
End Function
