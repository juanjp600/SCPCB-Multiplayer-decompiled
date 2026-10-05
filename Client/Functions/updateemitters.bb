Function updateemitters%()
    Local local0%
    Local local1%
    Local local2#
    Local local3#
    Local local4.emitters
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12.particles
    local0 = $00
    local1 = $01
    emittertimer = (emittertimer + fpsfactor)
    If (1.0 > emittertimer) Then
        Return $00
    EndIf
    local2 = entityx(camera, $01)
    local3 = entityz(camera, $01)
    For local4 = Each emitters
        local5 = entityx(local4\Field0, $01)
        local6 = entityz(local4\Field0, $01)
        local7 = distance2d(local5, local6, local2, local3)
        If (((hidedistance > local7) Lor (local4\Field6 = $00)) <> 0) Then
            local8 = entityy(local4\Field0, $01)
            local1 = $01
            If (local4\Field8 <> Null) Then
                If (local4\Field8\Field69 = $00) Then
                    local1 = $00
                EndIf
            EndIf
            local4\Field9 = loopsound2(hisssfx, local4\Field9, camera, local4\Field0, 4.0, 0.8)
            If (local1 <> 0) Then
                If (0.0 >= local4\Field19) Then
                    local9 = local4\Field10
                    local10 = local4\Field11
                    local11 = local4\Field12
                    If (0.0 <> ((local9 + local10) + local11)) Then
                        local5 = (rnd((- local9), local9) + local5)
                        local8 = (rnd((- local10), local10) + local8)
                        local6 = (rnd((- local11), local11) + local6)
                    EndIf
                    local12 = createparticle(local5, local8, local6, rand(local4\Field2, local4\Field3), local4\Field1, local4\Field4, local4\Field5, 1.0, local4\Field6)
                    If (local12 <> Null) Then
                        local12\Field6 = local4\Field13
                        rotateentity(local12\Field1, entitypitch(local4\Field0, $01), entityyaw(local4\Field0, $01), entityroll(local4\Field0, $01), $01)
                        turnentity(local12\Field1, rnd((- local4\Field14), local4\Field14), rnd((- local4\Field14), local4\Field14), 0.0, $00)
                        turnentity(local12\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
                        local12\Field13 = local4\Field15
                        local12\Field5 = local4\Field17
                        local12\Field12 = local4\Field16
                        If (local12\Field2 = $06) Then
                            emittertimer = 0.0
                            Return $00
                        EndIf
                    EndIf
                    If (0.0 <> local4\Field18) Then
                        local4\Field18 = (local4\Field18 - emittertimer)
                        If (1.0 > local4\Field18) Then
                            freeentity(local4\Field0)
                            Delete local4
                            emittertimer = 0.0
                            Return $00
                        EndIf
                    EndIf
                    local4\Field19 = (Float (($02 - particleamount) + $01))
                Else
                    local4\Field19 = (local4\Field19 - emittertimer)
                EndIf
            EndIf
            If (local0 = $00) Then
                If ((wearinggasmask + wearinghazmat) = $00) Then
                    If (0.64 > local7) Then
                        If (5.0 > (Abs (entityy(camera, $01) - local8))) Then
                            local0 = $01
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    updatesmokecough(local0)
    emittertimer = 0.0
    Return $00
End Function
