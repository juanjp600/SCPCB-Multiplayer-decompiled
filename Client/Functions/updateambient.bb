Function updateambient%()
    Local local0%
    Local local2$
    shouldplay = (Int min((Float playerzone), 2.0))
    If ((((playerroom\Field7\Field11 <> "pocketdimension") And (playerroom\Field7\Field11 <> "gatea")) And (playerroom\Field7\Field11 <> "exit1")) <> 0) Then
        If (rand($5DC, $01) = $01) Then
            For local0 = $00 To $05 Step $01
                If (ambientsfx(local0, currambientsfx) <> $00) Then
                    If (channelplaying(ambientsfxchn) = $00) Then
                        freesound_strict(ambientsfx(local0, currambientsfx))
                        ambientsfx(local0, currambientsfx) = $00
                    EndIf
                EndIf
            Next
            positionentity(soundemitter, (entityx(camera, $00) + rnd(-1.0, 1.0)), 0.0, (entityz(camera, $00) + rnd(-1.0, 1.0)), $00)
            If (rand($03, $01) = $01) Then
                playerzone = $03
            EndIf
            If (playerroom\Field7\Field11 = "173") Then
                playerzone = $04
            ElseIf (playerroom\Field7\Field11 = "room860") Then
                If (1.0 = room860event\Field2) Then
                    playerzone = $05
                    positionentity(soundemitter, entityx(soundemitter, $00), 30.0, entityz(soundemitter, $00), $00)
                EndIf
            EndIf
            currambientsfx = rand($00, (ambientsfxamount(playerzone) - $01))
            Select playerzone
                Case $00,$01,$02
                    If (ambientsfx(playerzone, currambientsfx) = $00) Then
                        ambientsfx(playerzone, currambientsfx) = loadsound_strict((((("SFX\Ambient\Zone" + (Str (playerzone + $01))) + "\ambient") + (Str (currambientsfx + $01))) + ".ogg"))
                    EndIf
                Case $03
                    If (ambientsfx(playerzone, currambientsfx) = $00) Then
                        ambientsfx(playerzone, currambientsfx) = loadsound_strict((("SFX\Ambient\General\ambient" + (Str (currambientsfx + $01))) + ".ogg"))
                    EndIf
                Case $04
                    If (ambientsfx(playerzone, currambientsfx) = $00) Then
                        ambientsfx(playerzone, currambientsfx) = loadsound_strict((("SFX\Ambient\Pre-breach\ambient" + (Str (currambientsfx + $01))) + ".ogg"))
                    EndIf
                Case $05
                    If (ambientsfx(playerzone, currambientsfx) = $00) Then
                        ambientsfx(playerzone, currambientsfx) = loadsound_strict((("SFX\Ambient\Forest\ambient" + (Str (currambientsfx + $01))) + ".ogg"))
                    EndIf
            End Select
            ambientsfxchn = playsound2(ambientsfx(playerzone, currambientsfx), camera, soundemitter, 10.0, 1.0)
        EndIf
        updatesoundorigin(ambientsfxchn, camera, soundemitter, 10.0, 1.0)
        If (rand($C350, $01) = $03) Then
            local2 = playerroom\Field7\Field11
            If (((((local2 <> "room860") And (local2 <> "room1123")) And (local2 <> "173")) And (local2 <> "dimension1499")) <> 0) Then
                If (0.0 < fpsfactor) Then
                    lightblink = rnd(1.0, 2.0)
                EndIf
                playsound_strict(loadtempsound((("SFX\SCP\079\Broadcast" + (Str rand($01, $07))) + ".ogg")))
            EndIf
        EndIf
        shouldplay = (Int min((Float playerzone), 2.0))
    EndIf
    Return $00
End Function
