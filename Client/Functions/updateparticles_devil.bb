Function updateparticles_devil%()
    Local local0.emitter
    Local local1.particle
    Local local2%
    Local local3%
    Local local4#
    Local local5%
    Local local6#
    Local local8%
    Local local9#
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    Local local15%
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
    Local local28#
    Local local29#
    Local local30#
    Local local31#
    Local local32#
    Local local33%
    Local local34%
    Local local35%
    Local local36%
    Local local37#
    Local local38#
    Local local39%
    Local local40%
    Local local41%
    Local local42#
    local3 = $00
    local4 = ((Float ($03 - opt\Field0)) * 2.0)
    For local0 = Each emitter
        clearsurface(local0\Field8, $01, $01)
        If (-1.0 < local0\Field2) Then
            local0\Field1 = (local0\Field1 + 1.0)
            If (local0\Field2 < local0\Field1) Then
                local0\Field9 = $01
            EndIf
        EndIf
        If (((0.0 < fps\Field7[$00]) And ((local0\Field10 = Null) Lor ((playerroom = local0\Field10) Lor (8.0 > local0\Field10\Field8)))) <> 0) Then
            If (local0\Field3\Field4 > $FFFFFFFF) Then
                local5 = $00
                For local1 = Each particle
                    If (local1\Field0 = local0) Then
                        local5 = (local5 + $01)
                    EndIf
                Next
            EndIf
            local0\Field0 = ((local0\Field0 + 1.0) Mod (Float local0\Field3\Field2))
            If ((((0.0 = local0\Field0) And (local0\Field9 = $00)) And (0.0 >= local0\Field13)) <> 0) Then
                For local2 = $01 To local0\Field3\Field3 Step $01
                    If ((((local0\Field3\Field4 > $FFFFFFFF) And (local5 < local0\Field3\Field4)) Lor (local0\Field3\Field4 = $FFFFFFFF)) <> 0) Then
                        local1 = (New particle)
                        local1\Field0 = local0
                        local1\Field2 = rand(local0\Field3\Field5, local0\Field3\Field6)
                        local1\Field3 = (rnd(local0\Field3\Field12, local0\Field3\Field13) + entityx(local0\Field6, $01))
                        local1\Field4 = (rnd(local0\Field3\Field14, local0\Field3\Field15) + entityy(local0\Field6, $01))
                        local1\Field5 = (rnd(local0\Field3\Field16, local0\Field3\Field17) + entityz(local0\Field6, $01))
                        local1\Field6 = rnd(local0\Field3\Field18, local0\Field3\Field19)
                        local1\Field7 = rnd(local0\Field3\Field20, local0\Field3\Field21)
                        local1\Field8 = rnd(local0\Field3\Field22, local0\Field3\Field23)
                        local1\Field10 = rnd(local0\Field3\Field24, local0\Field3\Field25)
                        local6 = rnd(local0\Field3\Field33, local0\Field3\Field34)
                        local1\Field11 = (local1\Field0\Field3\Field31 * local6)
                        local1\Field12 = (local1\Field0\Field3\Field32 * local6)
                    EndIf
                Next
                local0\Field13 = local4
            EndIf
            local0\Field13 = (local0\Field13 - fps\Field7[$00])
            If (local0\Field3\Field8 <> 0) Then
                local0\Field3\Field9 = (local0\Field3\Field9 + local0\Field3\Field11)
                If ((Float (local0\Field3\Field10 - $01)) < local0\Field3\Field9) Then
                    local0\Field3\Field9 = 0.0
                EndIf
                entitytexture(local0\Field7, local0\Field3\Field7, (Int local0\Field3\Field9), $00)
            EndIf
            Select local0\Field11
                Case $01
                    local0\Field12 = loopsoundex(snd_i\Field26[$00], local0\Field12, camera, local0\Field6, 10.0, 1.0, $00)
                    If (local3 = $00) Then
                        If (((wi\Field0 = $00) And (wi\Field2 = $00)) <> 0) Then
                            If (0.64 > distancesquared(entityx(camera, $01), entityx(local0\Field6, $01), entityz(camera, $01), entityz(local0\Field6, $01), 0.0, 0.0)) Then
                                If (5.0 > (Abs (entityy(camera, $01) - entityy(local0\Field6, $01)))) Then
                                    local3 = $01
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Case $02,$03
                    local0\Field12 = loopsoundex(snd_i\Field26[$01], local0\Field12, camera, local0\Field6, (5.0 - ((Float (3.0 = (Float local0\Field11))) * 3.0)), (1.0 - ((Float (3.0 = (Float local0\Field11))) * 0.6)), $00)
            End Select
        EndIf
        If (local0\Field9 <> 0) Then
            local8 = $01
            For local1 = Each particle
                If (local1\Field0 = local0) Then
                    local8 = $00
                EndIf
            Next
            If (local8 <> 0) Then
                freeentity(local0\Field7)
                local0\Field7 = $00
                local0\Field8 = $00
                freeentity(local0\Field6)
                local0\Field6 = $00
                stopchannel(local0\Field12)
                local0\Field12 = $00
                Delete local0
            EndIf
        EndIf
    Next
    If (local3 <> 0) Then
        If (420.0 < me\Field14) Then
            me\Field48 = max(me\Field48, ((me\Field14 - 420.0) / 1680.0))
        EndIf
        If (1680.0 < me\Field14) Then
            msg\Field2 = format(getlocalstring("death", "smoke"), subjectname, "%s")
            kill($00, $01, $00, $01)
        EndIf
        updatecough($96)
        me\Field14 = (me\Field14 + (fps\Field7[$00] * 4.0))
    EndIf
    positionentity(particlepiv, entityx(particlecam, $01), entityy(particlecam, $01), entityz(particlecam, $01), $00)
    local9 = entitypitch(particlecam, $01)
    local10 = entityyaw(particlecam, $01)
    local11 = entityroll(particlecam, $01)
    For local1 = Each particle
        If ((((hidedistance * hidedistance) < entitydistancesquared(local1\Field0\Field6, me\Field60)) Lor (local1\Field1 > local1\Field2)) <> 0) Then
            Delete local1
        Else
            local1\Field1 = (local1\Field1 + $01)
            If (local1\Field0\Field3\Field26 <> 0) Then
                local1\Field9 = ((Float local1\Field0\Field3\Field27) - atan2(local1\Field6, local1\Field7))
            Else
                local1\Field9 = (local1\Field9 + local1\Field10)
            EndIf
            local1\Field7 = (local1\Field7 - local1\Field0\Field3\Field28)
            If (local1\Field0\Field10 <> Null) Then
                local12 = entityyaw(local1\Field0\Field10\Field2, $00)
                local13 = sin(local12)
                local14 = cos(local12)
                local1\Field3 = (((local1\Field6 * local14) + (local1\Field8 * local13)) + local1\Field3)
                local1\Field4 = (local1\Field4 + local1\Field7)
                local1\Field5 = (((local1\Field6 * local13) + (local1\Field8 * local14)) + local1\Field5)
            Else
                local1\Field3 = (local1\Field3 + local1\Field6)
                local1\Field4 = (local1\Field4 + local1\Field7)
                local1\Field5 = (local1\Field5 + local1\Field8)
            EndIf
            local15 = $00
            If (local1\Field0\Field3\Field46 = $01) Then
                If (local1\Field0\Field3\Field44 <= local1\Field4) Then
                    local15 = $01
                EndIf
            ElseIf (local1\Field0\Field3\Field46 = $00) Then
                If (local1\Field0\Field3\Field44 > local1\Field4) Then
                    local15 = $01
                EndIf
            EndIf
            If (local15 <> 0) Then
                local1\Field7 = (local1\Field7 * (- local1\Field0\Field3\Field45))
            EndIf
            local1\Field11 = ((local1\Field11 + local1\Field0\Field3\Field35) * local1\Field0\Field3\Field36)
            local1\Field12 = ((local1\Field12 + local1\Field0\Field3\Field35) * local1\Field0\Field3\Field36)
            rotateentity(particlepiv, local9, local10, ((local1\Field9 + (Float local1\Field0\Field3\Field27)) + local11), $00)
            If (local1\Field0\Field3\Field47 > $FFFFFFFF) Then
                rotateentity(particlepiv, (Float local1\Field0\Field3\Field47), entityyaw(particlepiv, $00), entityroll(particlepiv, $00), $00)
            EndIf
            If (local1\Field0\Field3\Field48 > $FFFFFFFF) Then
                rotateentity(particlepiv, entitypitch(particlepiv, $00), (Float local1\Field0\Field3\Field48), entityroll(particlepiv, $00), $00)
            EndIf
            local16 = (entityx(local1\Field0\Field7, $00) + local1\Field3)
            local17 = (entityy(local1\Field0\Field7, $00) + local1\Field4)
            local18 = (entityz(local1\Field0\Field7, $00) + local1\Field5)
            local19 = local1\Field11
            local20 = local1\Field12
            tformvector(local19, (- local20), 0.0, particlepiv, $00)
            local21 = (tformedx() + local16)
            local22 = (tformedy() + local17)
            local23 = (tformedz() + local18)
            tformvector((- local19), (- local20), 0.0, particlepiv, $00)
            local24 = (tformedx() + local16)
            local25 = (tformedy() + local17)
            local26 = (tformedz() + local18)
            tformvector(local19, local20, 0.0, particlepiv, $00)
            local27 = (tformedx() + local16)
            local28 = (tformedy() + local17)
            local29 = (tformedz() + local18)
            tformvector((- local19), local20, 0.0, particlepiv, $00)
            local30 = (tformedx() + local16)
            local31 = (tformedy() + local17)
            local32 = (tformedz() + local18)
            local33 = addvertex(local1\Field0\Field8, local21, local22, local23, 0.0, 0.0, 1.0)
            local34 = addvertex(local1\Field0\Field8, local24, local25, local26, 1.0, 0.0, 1.0)
            local35 = addvertex(local1\Field0\Field8, local27, local28, local29, 0.0, 1.0, 1.0)
            local36 = addvertex(local1\Field0\Field8, local30, local31, local32, 1.0, 1.0, 1.0)
            local37 = (Float local1\Field1)
            local38 = (Float local1\Field2)
            local39 = (Int ((((Float (local1\Field0\Field3\Field40 - local1\Field0\Field3\Field37)) * local37) / local38) + (Float local1\Field0\Field3\Field37)))
            local40 = (Int ((((Float (local1\Field0\Field3\Field41 - local1\Field0\Field3\Field38)) * local37) / local38) + (Float local1\Field0\Field3\Field38)))
            local41 = (Int ((((Float (local1\Field0\Field3\Field42 - local1\Field0\Field3\Field39)) * local37) / local38) + (Float local1\Field0\Field3\Field39)))
            If (local1\Field0\Field3\Field30 <> 0) Then
                local42 = ((1.0 - (local37 / local38)) * local1\Field0\Field3\Field29)
            Else
                local42 = local1\Field0\Field3\Field29
            EndIf
            vertexcolor(local1\Field0\Field8, local33, (Float local39), (Float local40), (Float local41), local42)
            vertexcolor(local1\Field0\Field8, local34, (Float local39), (Float local40), (Float local41), local42)
            vertexcolor(local1\Field0\Field8, local35, (Float local39), (Float local40), (Float local41), local42)
            vertexcolor(local1\Field0\Field8, local36, (Float local39), (Float local40), (Float local41), local42)
            For local2 = $01 To local1\Field0\Field3\Field43 Step $01
                addtriangle(local1\Field0\Field8, local33, local34, local35)
                addtriangle(local1\Field0\Field8, local35, local34, local36)
            Next
        EndIf
    Next
    Return $00
End Function
