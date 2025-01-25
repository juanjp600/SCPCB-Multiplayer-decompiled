Function updatedecals%()
    Local local0.decals
    Local local1#
    Local local2%
    Local local3#
    Local local4#
    Local local5.decals
    Local local6#
    Local local7#
    For local0 = Each decals
        If ((hidedistance * hidedistance) > entitydistancesquared(local0\Field0, me\Field60)) Then
            If (entityhidden(local0\Field0) <> 0) Then
                showentity(local0\Field0)
            EndIf
            local1 = entityy(local0\Field0, $01)
            If (0.0 <> local0\Field4) Then
                local0\Field3 = ((local0\Field4 * fps\Field7[$00]) + local0\Field3)
                scaleentity(local0\Field0, local0\Field3, local0\Field3, 1.0, $01)
                local2 = local0\Field2
                If (local2 = $00) Then
                    If (0.0 >= local0\Field13) Then
                        local3 = rnd(360.0, 0.0)
                        local4 = rnd(local0\Field3, 0.0)
                        local5 = createdecal($01, (entityx(local0\Field0, $01) + (cos(local3) * local4)), (local1 - 0.0005), (entityz(local0\Field0, $01) + (sin(local3) * local4)), entitypitch(local0\Field0, $01), entityyaw(local0\Field0, $01), entityroll(local0\Field0, $01), rnd(0.1, 0.5), 1.0, $00, $01, $00, $00, $00)
                        entityparent(local5\Field0, getparent(local0\Field0), $01)
                        playsoundex(snd_i\Field24[rand($03, $01)], camera, local5\Field0, 10.0, rnd(0.1, 0.5), $00, $00)
                        local0\Field13 = rnd(50.0, 100.0)
                    Else
                        local0\Field13 = (local0\Field13 - fps\Field7[$00])
                    EndIf
                EndIf
                If (local0\Field5 <= local0\Field3) Then
                    local0\Field4 = 0.0
                    local0\Field3 = local0\Field5
                EndIf
            EndIf
            If (0.0 <> local0\Field7) Then
                local0\Field6 = min(((fps\Field7[$00] * local0\Field7) + local0\Field6), 1.0)
                entityalpha(local0\Field0, local0\Field6)
            EndIf
            If (0.0 < local0\Field14) Then
                local0\Field14 = max((local0\Field14 - fps\Field7[$00]), 5.0)
            EndIf
            local6 = distancesquared(entityx(me\Field60, $00), entityx(local0\Field0, $01), entityz(me\Field60, $00), entityz(local0\Field0, $01), 0.0, 0.0)
            local7 = ((local0\Field3 * 0.8) * (local0\Field3 * 0.8))
            If ((((local7 > local6) And (90.0 = (Float (Int entitypitch(local0\Field0, $01))))) And (0.05 > (Abs ((entityy(me\Field60, $00) - 0.3) - local1)))) <> 0) Then
                Select local0\Field2
                    Case $00
                        If (local0\Field9 <> $01) Then
                            decalstep = $01
                            me\Field38 = curvevalue(0.0, me\Field38, max((100.0 - (sqr((local7 - local6)) * 15.0)), 1.0))
                            me\Field40 = max(me\Field40, ((local7 - local6) / 2.0))
                        Else
                            dustparticlechance = $01
                        EndIf
                    Case $02,$03,$04,$05,$06,$07,$10,$11,$12,$14,$15
                        decalstep = $02
                End Select
            EndIf
            If ((((0.0 >= local0\Field3) Lor (0.0 >= local0\Field6)) Lor (5.0 = local0\Field14)) <> 0) Then
                removedecal(local0)
            EndIf
        ElseIf (entityhidden(local0\Field0) = $00) Then
            hideentity(local0\Field0)
        EndIf
    Next
    Return $00
End Function
