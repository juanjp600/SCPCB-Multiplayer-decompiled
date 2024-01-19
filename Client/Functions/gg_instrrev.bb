Function gg_instrrev%(arg0$, arg1$)
    Local local0%
    local0 = ((len(arg0) - len(arg1)) + $01)
    While (local0 >= $01)
        If (((len(arg1) + local0) - $01) <= len(arg0)) Then
            If (mid(arg0, local0, len(arg1)) = arg1) Then
                Return local0
            EndIf
        EndIf
        local0 = (local0 + $FFFFFFFF)
    Wend
    Return $00
    Return $00
End Function
