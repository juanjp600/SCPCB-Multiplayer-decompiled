Function updatedeafplayer%()
    If (0.0 < deaftimer) Then
        deaftimer = (deaftimer - fpsfactor)
        sfxvolume = curvevalue(0.0, sfxvolume, 5.0)
        If (0.0 < sfxvolume) Then
            controlsoundvolume()
        EndIf
    Else
        deaftimer = 0.0
        sfxvolume = curvevalue(prevsfxvolume, sfxvolume, 40.0)
        If (deafplayer <> 0) Then
            controlsoundvolume()
        EndIf
        If (0.001 > sqrvalue((prevsfxvolume - sfxvolume))) Then
            deafplayer = $00
        EndIf
    EndIf
    Return $00
End Function
