Function countchars%(arg0$, arg1$)
    Local local0%
    Local local1%
    local0 = $00
    For local1 = $01 To len(arg0) Step $01
        If (mid(arg0, local1, $01) = arg1) Then
            local0 = (local0 + $01)
        EndIf
    Next
    Return local0
    Return $00
End Function
