Function gg_create_text_block.tgg_textline(arg0$, arg1%, arg2%, arg3#, arg4#, arg5%)
    Local local0%
    Local local1%
    Local local2$
    Local local3%
    Local local4#
    Local local5%
    Local local6.tgg_textline
    If (arg2 > $01) Then
        arg4 = 1.0
    EndIf
    If (arg1 > $FA) Then
        arg1 = $FA
    EndIf
    local1 = createpivot(arg5)
    While (arg0 <> "")
        If (len(arg0) >= arg1) Then
            local2 = left(arg0, arg1)
        Else
            local2 = arg0
        EndIf
        If (len(local2) = arg1) Then
            local5 = gg_instrrev(local2, " ")
            If (local5 > $01) Then
                local2 = left(local2, (local5 - $01))
            Else
                local5 = arg1
            EndIf
            arg0 = mid(arg0, (local5 + $01), $FFFFFFFF)
        Else
            arg0 = ""
        EndIf
        If (((arg0 = "") And (arg2 > $01)) <> 0) Then
            arg2 = $FFFFFFFF
        EndIf
        local6 = gg_create_text_line(trim(local2), arg2, arg4, $01, local1)
        local0 = local6\Field0
        local6\Field11 = local1
        positionentity(local0, 0.0, local4, 0.0, $00)
        local4 = (local4 - (arg3 * 1.8))
    Wend
    Return local6
    Return Null
End Function
