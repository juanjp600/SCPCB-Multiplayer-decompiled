Function player_var_getid%(arg0%)
    Local local0%
    For local0 = $01 To $FF Step $01
        If (player[arg0]\Field45[local0] = Null) Then
            Return local0
        EndIf
    Next
    Return $00
End Function
