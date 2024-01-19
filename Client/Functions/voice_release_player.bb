Function voice_release_player%(arg0.players)
    If (menu_open_type = $02) Then
        Return $00
    EndIf
    If (((arg0\Field52 Or ((arg0\Field51 = $00) And (myplayer\Field51 = $00))) Or (mainmenuopen = $01)) <> 0) Then
        voice_wave_create(arg0\Field0, arg0\Field60, arg0\Field65, $00)
    ElseIf (arg0\Field51 <> $00) Then
        If (((arg0\Field67 = myplayer\Field67) And (arg0\Field67 <> $00)) <> 0) Then
            voice_wave_create(arg0\Field0, arg0\Field60, (arg0\Field65 / 1.2), $00)
        EndIf
        If (20.0 >= entitydistance(collider, arg0\Field13)) Then
            voice_wave_create(arg0\Field0, arg0\Field60, arg0\Field65, arg0\Field13)
        EndIf
    EndIf
    Return $00
End Function
