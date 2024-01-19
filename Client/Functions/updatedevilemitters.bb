Function updatedevilemitters%()
    Local local0.devilemitters
    Local local1%
    Local local2#
    local1 = $00
    For local0 = Each devilemitters
        If ((((0.0 < fpsfactor) And local0\Field5\Field69) And (removeparticles = $00)) <> 0) Then
            If (0.0 = local0\Field6) Then
                setemitter(local0\Field0, particleeffect[local0\Field4], $00, $00)
                local0\Field6 = fpsfactor
            ElseIf (local0\Field7 > local0\Field6) Then
                local0\Field6 = min((local0\Field6 + fpsfactor), local0\Field7)
            Else
                local0\Field6 = 0.0
            EndIf
            If (local0\Field9 <> 0) Then
                local0\Field8 = loopsound2(hisssfx, local0\Field8, camera, local0\Field0, 10.0, 1.0)
                If (local1 = $00) Then
                    If (((wearinggasmask = $00) And (wearinghazmat = $00)) <> 0) Then
                        local2 = distance(entityx(camera, $01), entityz(camera, $01), entityx(local0\Field0, $01), entityz(local0\Field0, $01))
                        If (0.8 > local2) Then
                            If (5.0 > (Abs (entityy(camera, $01) - entityy(local0\Field0, $01)))) Then
                                local1 = $01
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    If (local1 <> 0) Then
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
                    multiplayer_writesound(coughsfx(rand($00, $02)), 0.0, 0.0, 0.0, 8.0, rnd(0.3, 0.5))
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
