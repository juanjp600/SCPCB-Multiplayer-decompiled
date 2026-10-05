Function bullethitmessage%()
    Local local0$
    If (godmode = $00) Then
        turnentity(camera, rnd(-3.0, 3.0), rnd(-3.0, 3.0), 0.0, $00)
        If (wearingvest > $00) Then
            If (wearingvest = $01) Then
                Select rand($08, $01)
                    Case $01,$02,$03,$04,$05
                        blurtimer = 500.0
                        stamina = 0.0
                        local0 = "A bullet penetrated your vest, making you gasp."
                        injuries = (rnd(0.1, 0.5) + injuries)
                    Case $06
                        blurtimer = 500.0
                        local0 = "A bullet hit your left leg."
                        injuries = (rnd(0.8, 1.2) + injuries)
                    Case $07
                        blurtimer = 500.0
                        local0 = "A bullet hit your right leg."
                        injuries = (rnd(0.8, 1.2) + injuries)
                    Case $08
                        blurtimer = 500.0
                        stamina = 0.0
                        local0 = "A bullet struck your neck, making you gasp."
                        injuries = (rnd(1.2, 1.6) + injuries)
                End Select
            ElseIf (rand($0A, $01) = $01) Then
                blurtimer = 500.0
                stamina = (stamina - 1.0)
                local0 = "A bullet hit your chest. The vest absorbed some of the damage."
                injuries = (rnd(0.8, 1.1) + injuries)
            Else
                local0 = "A bullet hit your chest. The vest absorbed most of the damage."
                injuries = (rnd(0.1, 0.5) + injuries)
            EndIf
            If (5.0 <= injuries) Then
                If (rand($03, $01) = $01) Then
                    kill("was killed by shoot", $00)
                EndIf
            EndIf
        Else
            Select rand($06, $01)
                Case $01
                    kill("was killed by shoot", $00)
                Case $02
                    blurtimer = 500.0
                    local0 = "A bullet hit your left leg."
                    injuries = (rnd(0.8, 1.2) + injuries)
                Case $03
                    blurtimer = 500.0
                    local0 = "A bullet hit your right leg."
                    injuries = (rnd(0.8, 1.2) + injuries)
                Case $04
                    blurtimer = 500.0
                    local0 = "A bullet hit your right shoulder."
                    injuries = (rnd(0.8, 1.2) + injuries)
                Case $05
                    blurtimer = 500.0
                    local0 = "A bullet hit your left shoulder."
                    injuries = (rnd(0.8, 1.2) + injuries)
                Case $06
                    blurtimer = 500.0
                    local0 = "A bullet hit your right shoulder."
                    injuries = (rnd(2.5, 4.0) + injuries)
            End Select
        EndIf
        If (248.0 > msgtimer) Then
            msg = local0
            msgtimer = 320.0
        EndIf
        injuries = min(injuries, 4.0)
        playsound_strict(bullethitsfx)
        multiplayer_writesound(bullethitsfx, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 5.0, 1.0)
    EndIf
    Return $00
End Function
