Function c_str$(arg0%)
    Local local0$
    Local local1%
    For local1 = $00 To (banksize(arg0) - $01) Step $01
        If (peekbyte(arg0, local1) <> $00) Then
            local0 = (local0 + chr(peekbyte(arg0, local1)))
        Else
            Exit
        EndIf
    Next
    Return local0
    Return ""
End Function
