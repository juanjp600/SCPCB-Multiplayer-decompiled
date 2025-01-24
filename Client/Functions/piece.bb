Function piece$(arg0$, arg1%, arg2$)
    Local local0%
    Local local1%
    Local local2$
    While (instr(arg0, (arg2 + arg2), $01) <> 0)
        arg0 = replace(arg0, (arg2 + arg2), arg2)
    Wend
    For local0 = $01 To (arg1 - $01) Step $01
        local1 = instr(arg0, arg2, $01)
        arg0 = mid(arg0, (local1 + $01), $FFFFFFFF)
    Next
    local1 = instr(arg0, arg2, $01)
    If (local1 < $01) Then
        local2 = arg0
    Else
        local2 = left(arg0, (local1 - $01))
    EndIf
    Return local2
    Return ""
End Function
