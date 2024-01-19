Function updateemitters%()
    Local local0%
    Local local1%
    Local local2.emitters
    Local local3.particles
    Local local4#
    local0 = $00
    local1 = $01
    For local2 = Each emitters
        If ((hidedistance * 2.0) > entitydistance(collider, local2\Field0)) Then
            local1 = $01
            If (local2\Field7 <> Null) Then
                If (local2\Field7\Field69 = $00) Then
                    local1 = $00
                EndIf
            EndIf
            local2\Field8 = loopsound2(hisssfx, local2\Field8, camera, local2\Field0, 10.0, 1.0)
            If (local1 <> 0) Then
                If (0.0 >= local2\Field15) Then
                    local3 = createparticle(entityx(local2\Field0, $01), entityy(local2\Field0, $01), entityz(local2\Field0, $01), rand(local2\Field2, local2\Field3), local2\Field1, local2\Field4, local2\Field5)
                    local3\Field9 = local2\Field9
                    rotateentity(local3\Field1, entitypitch(local2\Field0, $01), entityyaw(local2\Field0, $01), entityroll(local2\Field0, $01), $01)
                    turnentity(local3\Field1, rnd((- local2\Field10), local2\Field10), rnd((- local2\Field10), local2\Field10), 0.0, $00)
                    turnentity(local3\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
                    local3\Field16 = local2\Field11
                    local3\Field8 = local2\Field13
                    local3\Field15 = local2\Field12
                    If (0.0 <> local2\Field14) Then
                        local2\Field14 = (local2\Field14 - fpsfactor)
                        If (1.0 > local2\Field14) Then
                            freeentity(local2\Field0)
                            Delete local2
                            Return $00
                        EndIf
                    EndIf
                    local2\Field15 = (Float (($02 - particleamount) + $01))
                Else
                    local2\Field15 = (local2\Field15 - fpsfactor)
                EndIf
            EndIf
            If (local0 = $00) Then
                If (((wearinggasmask = $00) And (wearinghazmat = $00)) <> 0) Then
                    local4 = distance(entityx(camera, $01), entityz(camera, $01), entityx(local2\Field0, $01), entityz(local2\Field0, $01))
                    If (0.8 > local4) Then
                        If (5.0 > (Abs (entityy(camera, $01) - entityy(local2\Field0, $01)))) Then
                            local0 = $01
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    updatesmokecough(local0)
    Return $00
End Function
