Function peekstring_work$(arg0%, arg1%)
    Local local0$
    Local local1%
    While (arg1 < banksize(arg0))
        local1 = peekbyte(arg0, arg1)
        If (((local1 = $0D) Or (local1 = $00)) <> 0) Then
            Exit
        EndIf
        If (local1 <> $0A) Then
            local0 = (local0 + (Str local1))
        EndIf
        arg1 = (arg1 + $01)
    Wend
    Return local0
    Return ""
End Function
