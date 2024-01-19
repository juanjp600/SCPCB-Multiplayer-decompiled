Function updateexistanimation%()
    Local local0%
    If (crouch = $01) Then
        player_move = $05
    Else
        player_move = $0B
    EndIf
    local0 = myplayer\Field51
    If (local0 = model_096) Then
        If (0.0 <> scp\Field7) Then
            player_move = $0E
        EndIf
        If (scp\Field3 <> 0) Then
            If ((((player_move = $05) Or (player_move = $0B)) Or (player_move = $0C)) <> 0) Then
                player_move = $0E
            EndIf
        ElseIf ((0.0 <> scp\Field7) = $00) Then
            If (player_move = $0D) Then
                player_move = $0C
            EndIf
        EndIf
    EndIf
    Return $00
End Function
