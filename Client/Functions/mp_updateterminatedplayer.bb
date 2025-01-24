Function mp_updateterminatedplayer%(arg0.mp_player)
    If (mp_terminated\Field5 > $00) Then
        If (arg0\Field4\Field15 = $00) Then
            arg0\Field4\Field15 = (mp_gettimer() + mp_terminated\Field5)
        EndIf
        arg0\Field4\Field6 = 0.0
        arg0\Field4\Field7 = 0.0
        arg0\Field4\Field8 = 0.0
        arg0\Field4\Field9 = 0.0
        arg0\Field4\Field10 = 210.0
        arg0\Field4\Field12 = 1.0
        arg0\Field4\Field13 = 0.0
        If (arg0\Field4\Field15 < mp_gettimer()) Then
            mp_respawnplayer(arg0)
        EndIf
    EndIf
    Return $00
End Function
