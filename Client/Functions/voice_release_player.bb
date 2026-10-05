Function voice_release_player%(arg0.players)
    If (menu_open_type = $02) Then
        Return $00
    EndIf
    If (((arg0\Field50 Or ((arg0\Field49 = $00) And (myplayer\Field49 = $00))) Or (mainmenuopen = $01)) <> 0) Then
        voice_wave_create(arg0\Field0, arg0\Field58, arg0\Field63, $00)
    ElseIf (arg0\Field49 <> $00) Then
        If (((arg0\Field65 = myplayer\Field65) And (arg0\Field65 <> $00)) <> 0) Then
            voice_wave_create(arg0\Field0, arg0\Field58, (arg0\Field63 / 1.2), $00)
        EndIf
        If (20.0 >= entitydistance(collider, arg0\Field13)) Then
            voice_wave_create(arg0\Field0, arg0\Field58, arg0\Field63, arg0\Field13)
        EndIf
    EndIf
    Return $00
End Function
