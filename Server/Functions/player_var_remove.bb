Function player_var_remove%(arg0%, arg1$)
    Local local0%
    For local0 = $01 To $FF Step $01
        If (player[arg0]\Field45[local0] <> Null) Then
            If (player[arg0]\Field45[local0]\Field0 = arg1) Then
                Delete player[arg0]\Field45[local0]
                Return $00
            EndIf
        EndIf
    Next
    Return $00
End Function
