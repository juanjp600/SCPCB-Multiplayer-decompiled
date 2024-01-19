Function updateparticles_devil%()
    Local local0.emitter
    Local local1.particle
    Local local2%
    Local local3%
    Local local4#
    Local local5%
    Local local6#
    Local local7%
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    Local local15#
    Local local16#
    Local local17#
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local22#
    Local local23#
    Local local24#
    Local local25#
    Local local26#
    Local local27#
    Local local28%
    Local local29%
    Local local30%
    Local local31%
    Local local32%
    Local local33%
    Local local34%
    Local local35#
    For local0 = Each emitter
        If (local0\Field4\Field4 > $FFFFFFFF) Then
            local2 = $00
            For local1 = Each particle
                If (local1\Field0 = local0) Then
                    local2 = (local2 + $01)
                EndIf
            Next
        EndIf
        clearsurface(local0\Field7, $01, $01)
        If (-1.0 < local0\Field3) Then
            If (local0\Field3 < local0\Field2) Then
                local0\Field8 = $01
            Else
                local0\Field2 = (local0\Field2 + 1.0)
            EndIf
        EndIf
        If (local0\Field9 = $00) Then
            local0\Field1 = ((local0\Field1 + 1.0) Mod (Float local0\Field4\Field2))
            If (((0.0 = local0\Field1) And (local0\Field8 = $00)) <> 0) Then
                For local3 = $01 To local0\Field4\Field3 Step $01
                    If ((((local0\Field4\Field4 > $FFFFFFFF) And (local2 < local0\Field4\Field4)) Or (local0\Field4\Field4 = $FFFFFFFF)) <> 0) Then
                        local1 = (New particle)
                        local1\Field0 = local0
                        local1\Field2 = rand(local0\Field4\Field6, local0\Field4\Field7)
                        local1\Field3 = (rnd(local0\Field4\Field13, local0\Field4\Field14) + entityx(local0\Field5, $01))
                        local1\Field4 = (rnd(local0\Field4\Field15, local0\Field4\Field16) + entityy(local0\Field5, $01))
                        local1\Field5 = (rnd(local0\Field4\Field17, local0\Field4\Field18) + entityz(local0\Field5, $01))
                        local1\Field6 = rnd(local0\Field4\Field19, local0\Field4\Field20)
                        local1\Field7 = rnd(local0\Field4\Field21, local0\Field4\Field22)
                        local1\Field8 = rnd(local0\Field4\Field23, local0\Field4\Field24)
                        local1\Field10 = rnd(local0\Field4\Field25, local0\Field4\Field26)
                        local4 = rnd(local0\Field4\Field34, local0\Field4\Field35)
                        local1\Field11 = (local1\Field0\Field4\Field32 * local4)
                        local1\Field12 = (local1\Field0\Field4\Field33 * local4)
                    EndIf
                Next
            EndIf
        EndIf
        If (local0\Field4\Field9 <> 0) Then
            local0\Field4\Field10 = (local0\Field4\Field10 + local0\Field4\Field12)
            If ((Float (local0\Field4\Field11 - $01)) < local0\Field4\Field10) Then
                local0\Field4\Field10 = 0.0
            EndIf
            entitytexture(local0\Field6, local0\Field4\Field8, (Int local0\Field4\Field10), $00)
        EndIf
        local5 = (Int ((Float local5) + local6))
        If (local0\Field8 <> 0) Then
            local7 = $01
            For local1 = Each particle
                If (local1\Field0 = local0) Then
                    local7 = $00
                EndIf
            Next
            If (local7 <> 0) Then
                freeentity(local0\Field6)
                If ((local0\Field0 And local0\Field5) <> 0) Then
                    freeentity(local0\Field5)
                EndIf
                Delete local0
            EndIf
        EndIf
    Next
    positionentity(particlepiv, entityx(particlecam, $01), entityy(particlecam, $01), entityz(particlecam, $01), $00)
    local8 = entitypitch(particlecam, $01)
    local9 = entityyaw(particlecam, $01)
    local10 = entityroll(particlecam, $01)
    For local1 = Each particle
        If (local1\Field1 > local1\Field2) Then
            Delete local1
        Else
            If (local1\Field0\Field9 = $00) Then
                local1\Field1 = (local1\Field1 + $01)
                If (local1\Field0\Field4\Field27 <> 0) Then
                    local1\Field9 = ((Float local1\Field0\Field4\Field28) - atan2(local1\Field6, local1\Field7))
                Else
                    local1\Field9 = (local1\Field9 + local1\Field10)
                EndIf
                local1\Field7 = (local1\Field7 - local1\Field0\Field4\Field29)
                local1\Field3 = (local1\Field3 + local1\Field6)
                local1\Field4 = (local1\Field4 + local1\Field7)
                local1\Field5 = (local1\Field5 + local1\Field8)
                If (local1\Field0\Field4\Field45 > local1\Field4) Then
                    local1\Field7 = (local1\Field7 * (- local1\Field0\Field4\Field46))
                EndIf
                local1\Field11 = ((local1\Field11 + local1\Field0\Field4\Field36) * local1\Field0\Field4\Field37)
                local1\Field12 = ((local1\Field12 + local1\Field0\Field4\Field36) * local1\Field0\Field4\Field37)
            EndIf
            rotateentity(particlepiv, local8, local9, ((local1\Field9 + (Float local1\Field0\Field4\Field28)) + local10), $00)
            If (local1\Field0\Field4\Field47 > $FFFFFFFF) Then
                rotateentity(particlepiv, (Float local1\Field0\Field4\Field47), entityyaw(particlepiv, $00), entityroll(particlepiv, $00), $00)
            EndIf
            If (local1\Field0\Field4\Field48 > $FFFFFFFF) Then
                rotateentity(particlepiv, entitypitch(particlepiv, $00), (Float local1\Field0\Field4\Field48), entityroll(particlepiv, $00), $00)
            EndIf
            local11 = (entityx(local1\Field0\Field6, $00) + local1\Field3)
            local12 = (entityy(local1\Field0\Field6, $00) + local1\Field4)
            local13 = (entityz(local1\Field0\Field6, $00) + local1\Field5)
            local14 = local1\Field11
            local15 = local1\Field12
            tformvector(local14, (- local15), 0.0, particlepiv, $00)
            local16 = (tformedx() + local11)
            local17 = (tformedy() + local12)
            local18 = (tformedz() + local13)
            tformvector((- local14), (- local15), 0.0, particlepiv, $00)
            local19 = (tformedx() + local11)
            local20 = (tformedy() + local12)
            local21 = (tformedz() + local13)
            tformvector(local14, local15, 0.0, particlepiv, $00)
            local22 = (tformedx() + local11)
            local23 = (tformedy() + local12)
            local24 = (tformedz() + local13)
            tformvector((- local14), local15, 0.0, particlepiv, $00)
            local25 = (tformedx() + local11)
            local26 = (tformedy() + local12)
            local27 = (tformedz() + local13)
            local28 = addvertex(local1\Field0\Field7, local16, local17, local18, 0.0, 0.0, 1.0)
            local29 = addvertex(local1\Field0\Field7, local19, local20, local21, 1.0, 0.0, 1.0)
            local30 = addvertex(local1\Field0\Field7, local22, local23, local24, 0.0, 1.0, 1.0)
            local31 = addvertex(local1\Field0\Field7, local25, local26, local27, 1.0, 1.0, 1.0)
            local32 = (Int ((((Float (local1\Field0\Field4\Field41 - local1\Field0\Field4\Field38)) * (Float local1\Field1)) / (Float local1\Field2)) + (Float local1\Field0\Field4\Field38)))
            local33 = (Int ((((Float (local1\Field0\Field4\Field42 - local1\Field0\Field4\Field39)) * (Float local1\Field1)) / (Float local1\Field2)) + (Float local1\Field0\Field4\Field39)))
            local34 = (Int ((((Float (local1\Field0\Field4\Field43 - local1\Field0\Field4\Field40)) * (Float local1\Field1)) / (Float local1\Field2)) + (Float local1\Field0\Field4\Field40)))
            If (local1\Field0\Field4\Field31 <> 0) Then
                local35 = ((1.0 - ((Float local1\Field1) / (Float local1\Field2))) * local1\Field0\Field4\Field30)
            Else
                local35 = local1\Field0\Field4\Field30
            EndIf
            vertexcolor(local1\Field0\Field7, local28, (Float local32), (Float local33), (Float local34), local35)
            vertexcolor(local1\Field0\Field7, local29, (Float local32), (Float local33), (Float local34), local35)
            vertexcolor(local1\Field0\Field7, local30, (Float local32), (Float local33), (Float local34), local35)
            vertexcolor(local1\Field0\Field7, local31, (Float local32), (Float local33), (Float local34), local35)
            For local3 = $01 To local1\Field0\Field4\Field44 Step $01
                addtriangle(local1\Field0\Field7, local28, local29, local30)
                addtriangle(local1\Field0\Field7, local30, local29, local31)
            Next
        EndIf
    Next
    Return $00
End Function
