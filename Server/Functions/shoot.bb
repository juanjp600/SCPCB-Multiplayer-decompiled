Function shoot%(arg0.npcs, arg1#, arg2#, arg3#, arg4#, arg5%, arg6%)
    Local local0$
    If (arg6 <> 0) Then
        If (godmode = $00) Then
            giveplayerhealth(arg0\Field74, -1000.0, "was killed by shoot")
            If (instr(player[arg0\Field74]\Field103, "BulletHit", $01) = $00) Then
                createsound("SFX\General\BulletHit.ogg", entityx(arg0\Field73, $00), entityy(arg0\Field73, $00), entityz(arg0\Field73, $00), 10.0, 1.0)
            EndIf
        EndIf
    EndIf
    If (arg4 >= rnd(1.0, 0.0)) Then
        If (player[arg0\Field74]\Field101 = $00) Then
            If (player[arg0\Field74]\Field21 > $00) Then
                If (player[arg0\Field74]\Field21 = $01) Then
                    Select rand($08, $01)
                        Case $01,$02,$03,$04,$05
                            blurtimer = 500.0
                            stamina = 0.0
                            local0 = "A bullet penetrated your vest, making you gasp."
                            giveplayerhealth(arg0\Field74, (Float (- rand($0A, $0F))), "was killed by shoot")
                        Case $06
                            blurtimer = 500.0
                            local0 = "A bullet hit your left leg."
                            giveplayerhealth(arg0\Field74, (Float (- rand($14, $19))), "was killed by shoot")
                        Case $07
                            blurtimer = 500.0
                            local0 = "A bullet hit your right leg."
                            giveplayerhealth(arg0\Field74, (Float (- rand($14, $19))), "was killed by shoot")
                        Case $08
                            blurtimer = 500.0
                            stamina = 0.0
                            local0 = "A bullet struck your neck, making you gasp."
                            giveplayerhealth(arg0\Field74, (Float (- rand($28, $32))), "was killed by shoot")
                    End Select
                ElseIf (rand($0A, $01) = $01) Then
                    blurtimer = 500.0
                    stamina = (stamina - 1.0)
                    local0 = "A bullet hit your chest. The vest absorbed some of the damage."
                    giveplayerhealth(arg0\Field74, (Float (- rand($0A, $0F))), "was killed by shoot")
                Else
                    local0 = "A bullet hit your chest. The vest absorbed most of the damage."
                    giveplayerhealth(arg0\Field74, (Float (- rand($0A, $0F))), "was killed by shoot")
                EndIf
                If (5.0 <= getplayerinjuries(arg0\Field74)) Then
                    If (rand($03, $01) = $01) Then
                        giveplayerhealth(arg0\Field74, -1000.0, "was killed by shoot")
                    EndIf
                EndIf
            Else
                Select rand($06, $01)
                    Case $01
                        giveplayerhealth(arg0\Field74, -1000.0, "was killed by shoot")
                    Case $02
                        blurtimer = 500.0
                        local0 = "A bullet hit your left leg."
                        giveplayerhealth(arg0\Field74, (Float (- rand($14, $19))), "was killed by shoot")
                    Case $03
                        blurtimer = 500.0
                        local0 = "A bullet hit your right leg."
                        giveplayerhealth(arg0\Field74, (Float (- rand($14, $19))), "was killed by shoot")
                    Case $04
                        blurtimer = 500.0
                        local0 = "A bullet hit your right shoulder."
                        giveplayerhealth(arg0\Field74, (Float (- rand($14, $19))), "was killed by shoot")
                    Case $05
                        blurtimer = 500.0
                        local0 = "A bullet hit your left shoulder."
                        giveplayerhealth(arg0\Field74, (Float (- rand($14, $19))), "was killed by shoot")
                    Case $06
                        blurtimer = 500.0
                        local0 = "A bullet hit your right shoulder."
                        giveplayerhealth(arg0\Field74, (Float (- rand($1E, $2D))), "was killed by shoot")
                End Select
            EndIf
            If (instr(player[arg0\Field74]\Field103, "BulletHit", $01) = $00) Then
                createsound("SFX\General\BulletHit.ogg", entityx(arg0\Field73, $00), entityy(arg0\Field73, $00), entityz(arg0\Field73, $00), 10.0, 1.0)
            EndIf
        Else
            giveplayerhealth(arg0\Field74, (Float (- rand($14, $1E))), "was killed by shoot")
            If (instr(player[arg0\Field74]\Field103, "BulletHit", $01) = $00) Then
                createsound("SFX\General\BulletHit.ogg", entityx(arg0\Field73, $00), entityy(arg0\Field73, $00), entityz(arg0\Field73, $00), 10.0, 1.0)
            EndIf
        EndIf
    EndIf
    Return $00
End Function
