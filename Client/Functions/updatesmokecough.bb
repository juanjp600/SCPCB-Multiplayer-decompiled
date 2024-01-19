Function updatesmokecough%(arg0%)
    If (arg0 <> 0) Then
        If (420.0 < eyeirritation) Then
            blurvolume = max(blurvolume, ((eyeirritation - 420.0) / 1680.0))
        EndIf
        If (1680.0 < eyeirritation) Then
            deathmsg = "Subject D-9341 found dead in [DATA REDACTED]. Cause of death: Suffocation due to decontamination gas."
            kill("was killed", $00)
        EndIf
        If (0.0 <= killtimer) Then
            If (rand($96, $01) = $01) Then
                If (coughchn = $00) Then
                    coughchn = playsound_strict(coughsfx(rand($00, $02)))
                    multiplayer_writesound(coughsfx(rand($00, $02)), 0.0, 0.0, 0.0, 10.0, 1.0)
                ElseIf (channelplaying(coughchn) = $00) Then
                    coughchn = playsound_strict(coughsfx(rand($00, $02)))
                    multiplayer_writesound(coughsfx(rand($00, $02)), 0.0, 0.0, 0.0, 8.0, rnd(0.3, 0.5))
                EndIf
            EndIf
        EndIf
        eyeirritation = ((fpsfactor * 4.0) + eyeirritation)
    EndIf
    Return $00
End Function
