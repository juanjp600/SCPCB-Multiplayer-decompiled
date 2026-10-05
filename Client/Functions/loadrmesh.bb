Function loadrmesh%(arg0$, arg1.roomtemplates)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5$
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%[2]
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18#
    Local local19#
    Local local20#
    Local local21%
    Local local22%
    Local local23%
    Local local24%
    Local local25%
    Local local26#
    Local local27#
    Local local28%
    Local local29%
    Local local30%
    Local local31%
    Local local32$
    Local local33%
    Local local34%
    Local local35$
    Local local36%
    Local local37%
    Local local38$
    Local local40$
    Local local41.tempscreens
    Local local42.tempwaypoints
    Local local43#
    Local local44$
    Local local45#
    Local local46%
    Local local47%
    Local local48%
    Local local50.lighttemplates
    Local local51$
    Local local52$
    Local local53$
    Local local54%
    Local local55%
    Local local56$
    Local local57#
    Local local58#
    Local local59#
    Local local60%
    Local local61#
    Local local62%
    Local local63$
    Local local64.props
    Local local65%
    Local local66%
    local1 = createpivot($00)
    local2 = $00
    For local3 = $00 To $03 Step $01
        If (local0 <> $00) Then
            Exit
        EndIf
        local0 = readfile(arg0)
    Next
    If (local0 = $00) Then
        runtimeerror(((("Error reading file " + chr($22)) + arg0) + chr($22)))
    EndIf
    local4 = readstring(local0)
    If (local4 <> "RoomMesh") Then
        If (local4 = "RoomMesh.HasTriggerBox") Then
            local2 = $01
        Else
            runtimeerror((((((chr($22) + arg0) + chr($22)) + " is Not RMESH (") + local4) + ")"))
        EndIf
    EndIf
    local5 = arg0
    arg0 = stripfilename(arg0)
    local8 = createmesh($00)
    local9 = createmesh($00)
    local6 = readint(local0)
    For local15 = $01 To local6 Step $01
        local10 = createmesh($00)
        local11 = createsurface(local10, $00)
        local13 = createbrush(255.0, 255.0, 255.0)
        local12[$00] = $00
        local12[$01] = $00
        local14 = $00
        For local16 = $00 To $01 Step $01
            local31 = readbyte(local0)
            If (local31 <> $00) Then
                local32 = readstring(local0)
                local12[local16] = gettexturefromcache(local32)
                If (local12[local16] = $00) Then
                    local33 = $01
                    If (local33 <> (local31 < $03)) Then
                        local12[local16] = loadtexture((arg0 + local32), $03)
                    Else
                        local12[local16] = loadtexture((arg0 + local32), $01)
                    EndIf
                    If (local12[local16] <> $00) Then
                        If (local31 = $01) Then
                            textureblend(local12[local16], $05)
                        EndIf
                        If (instr(lower(local32), "_lm", $01) <> $00) Then
                            textureblend(local12[local16], $03)
                        EndIf
                        addtexturetocache(local12[local16])
                    EndIf
                EndIf
                If (local12[local16] <> $00) Then
                    local14 = $02
                    If (local31 = $03) Then
                        local14 = $01
                    EndIf
                    texturecoords(local12[local16], ($01 - local16))
                EndIf
            EndIf
        Next
        If (local14 = $01) Then
            If (local12[$01] <> $00) Then
                textureblend(local12[$01], $02)
                brushtexture(local13, local12[$01], $00, $00)
            EndIf
        ElseIf (((local12[$00] <> $00) And (local12[$01] <> $00)) <> 0) Then
            local34 = getbumpfromcache(strippath(texturename(local12[$01])))
            For local16 = $00 To $01 Step $01
                brushtexture(local13, local12[local16], $00, ((local16 + $01) + (local34 <> $00)))
            Next
            brushtexture(local13, ambientlightroomtex, $00, $00)
            If (local34 <> $00) Then
                brushtexture(local13, local34, $00, $01)
            EndIf
        Else
            For local16 = $00 To $01 Step $01
                If (local12[local16] <> $00) Then
                    brushtexture(local13, local12[local16], $00, local16)
                EndIf
            Next
        EndIf
        local11 = createsurface(local10, $00)
        If (local14 > $00) Then
            paintsurface(local11, local13)
        EndIf
        freebrush(local13)
        local13 = $00
        local7 = readint(local0)
        For local16 = $01 To local7 Step $01
            local18 = readfloat(local0)
            local19 = readfloat(local0)
            local20 = readfloat(local0)
            local22 = addvertex(local11, local18, local19, local20, 0.0, 0.0, 1.0)
            For local17 = $00 To $01 Step $01
                local26 = readfloat(local0)
                local27 = readfloat(local0)
                vertextexcoords(local11, local22, local26, local27, 0.0, local17)
            Next
            local28 = readbyte(local0)
            local29 = readbyte(local0)
            local30 = readbyte(local0)
            vertexcolor(local11, local22, (Float local28), (Float local29), (Float local30), 1.0)
        Next
        local7 = readint(local0)
        For local16 = $01 To local7 Step $01
            local18 = (Float readint(local0))
            local19 = (Float readint(local0))
            local20 = (Float readint(local0))
            addtriangle(local11, (Int local18), (Int local19), (Int local20))
        Next
        If (local14 = $01) Then
            addmesh(local10, local9)
            entityalpha(local10, 0.0)
        Else
            addmesh(local10, local8)
            entityparent(local10, local1, $01)
            entityalpha(local10, 0.0)
            entitytype(local10, $01, $00)
            entitypickmode(local10, $02, $01)
        EndIf
        For local16 = $00 To $01 Step $01
            If (local12[local16] <> $00) Then
                local35 = lower(strippath(texturename(local12[local16])))
                If (((local35 = "glass.png") Xor (local35 = "matglass.png")) <> 0) Then
                    addmesh(local10, local8)
                    entityparent(local10, local1, $01)
                    entitytype(local10, $01, $00)
                    entitypickmode(local10, $02, $01)
                EndIf
            EndIf
        Next
    Next
    local36 = createmesh($00)
    local6 = readint(local0)
    For local15 = $01 To local6 Step $01
        local11 = createsurface(local36, $00)
        local7 = readint(local0)
        For local16 = $01 To local7 Step $01
            local18 = readfloat(local0)
            local19 = readfloat(local0)
            local20 = readfloat(local0)
            local22 = addvertex(local11, local18, local19, local20, 0.0, 0.0, 1.0)
        Next
        local7 = readint(local0)
        For local16 = $01 To local7 Step $01
            local23 = readint(local0)
            local24 = readint(local0)
            local25 = readint(local0)
            addtriangle(local11, local23, local24, local25)
            addtriangle(local11, local23, local25, local24)
        Next
    Next
    If (local2 <> 0) Then
        arg1\Field15 = readint(local0)
        For local37 = $00 To (arg1\Field15 - $01) Step $01
            arg1\Field16[local37] = createmesh(arg1\Field0)
            local6 = readint(local0)
            For local15 = $01 To local6 Step $01
                local11 = createsurface(arg1\Field16[local37], $00)
                local7 = readint(local0)
                For local16 = $01 To local7 Step $01
                    local18 = readfloat(local0)
                    local19 = readfloat(local0)
                    local20 = readfloat(local0)
                    local22 = addvertex(local11, local18, local19, local20, 0.0, 0.0, 1.0)
                Next
                local7 = readint(local0)
                For local16 = $01 To local7 Step $01
                    local23 = readint(local0)
                    local24 = readint(local0)
                    local25 = readint(local0)
                    addtriangle(local11, local23, local24, local25)
                    addtriangle(local11, local23, local25, local24)
                Next
            Next
            arg1\Field17[local37] = readstring(local0)
        Next
    EndIf
    local6 = readint(local0)
    For local15 = $01 To local6 Step $01
        local38 = readstring(local0)
        Select local38
            Case "screen"
                local18 = (readfloat(local0) * (1.0 / 256.0))
                local19 = (readfloat(local0) * (1.0 / 256.0))
                local20 = (readfloat(local0) * (1.0 / 256.0))
                local40 = readstring(local0)
                If (0.0 < (((Abs local18) + (Abs local19)) + (Abs local20))) Then
                    local41 = (New tempscreens)
                    local41\Field1 = local18
                    local41\Field2 = local19
                    local41\Field3 = local20
                    local41\Field0 = local40
                    local41\Field4 = arg1
                EndIf
            Case "waypoint"
                local42 = (New tempwaypoints)
                local42\Field0 = (readfloat(local0) * (1.0 / 256.0))
                local42\Field1 = (readfloat(local0) * (1.0 / 256.0))
                local42\Field2 = (readfloat(local0) * (1.0 / 256.0))
                local42\Field3 = arg1
            Case "light","spotlight"
                local18 = (readfloat(local0) * (1.0 / 256.0))
                local19 = (readfloat(local0) * (1.0 / 256.0))
                local20 = (readfloat(local0) * (1.0 / 256.0))
                If (0.0 < (((Abs local18) + (Abs local19)) + (Abs local20))) Then
                    local43 = (readfloat(local0) * 0.0005)
                    local44 = readstring(local0)
                    local45 = readfloat(local0)
                    local28 = $00
                    local29 = $00
                    local30 = $00
                    local46 = $00
                    local47 = len(local44)
                    For local16 = $01 To local47 Step $01
                        local48 = asc(mid(local44, local16, $01))
                        If (((local48 >= $30) And (local48 <= $39)) <> 0) Then
                            Select local46
                                Case $00
                                    local28 = ((local28 * $0A) + (local48 - $30))
                                Case $01
                                    local29 = ((local29 * $0A) + (local48 - $30))
                                Case $02
                                    local30 = ((local30 * $0A) + (local48 - $30))
                            End Select
                        ElseIf (local48 = $20) Then
                            local46 = (local46 + $01)
                            If (local46 > $02) Then
                                createconsolemsg(("light.load.error | " + local5), $FF, $00, $00, $00)
                                Exit
                            EndIf
                        EndIf
                    Next
                    If (1.0 < local45) Then
                        local45 = 1.0
                    Else
                        local45 = (local45 * 0.8)
                    EndIf
                    local28 = (Int ((Float local28) * local45))
                    local29 = (Int ((Float local29) * local45))
                    local30 = (Int ((Float local30) * local45))
                    local50 = addtemplight(arg1, local18, local19, local20, $02, local43, local28, local29, local30)
                    If (local38 = "spotlight") Then
                        local51 = readstring(local0)
                        local52 = ""
                        local53 = ""
                        local54 = $00
                        local55 = len(local51)
                        For local16 = $01 To local55 Step $01
                            local56 = mid(local51, local16, $01)
                            If (local56 = " ") Then
                                local54 = $01
                            ElseIf (local54 = $00) Then
                                local52 = (local52 + local56)
                            Else
                                local53 = (local53 + local56)
                            EndIf
                        Next
                        local50\Field9 = (Float local52)
                        local50\Field10 = (Float local53)
                        local50\Field11 = readint(local0)
                        local50\Field12 = (Float readint(local0))
                    EndIf
                Else
                    readfloat(local0)
                    readstring(local0)
                    readfloat(local0)
                    If (local38 = "spotlight") Then
                        readstring(local0)
                        readint(local0)
                        readint(local0)
                    EndIf
                EndIf
            Case "soundemitter"
                local57 = (readfloat(local0) * (1.0 / 256.0))
                local58 = (readfloat(local0) * (1.0 / 256.0))
                local59 = (readfloat(local0) * (1.0 / 256.0))
                local60 = readint(local0)
                local61 = readfloat(local0)
                local62 = $00
                For local16 = $00 To $0F Step $01
                    If (arg1\Field5[local16] = $00) Then
                        arg1\Field6[local16] = local57
                        arg1\Field7[local16] = local58
                        arg1\Field8[local16] = local59
                        arg1\Field5[local16] = local60
                        arg1\Field9[local16] = local61
                        local62 = $01
                        Exit
                    EndIf
                Next
                If (local62 = $00) Then
                    createconsolemsg(((("warning.roomSoundEmitters.maxAmount (15) | ID:" + (Str local60)) + " discarded at ") + local5), $FF, $64, $00, $00)
                EndIf
            Case "model"
                local63 = readstring(local0)
                If (local63 <> "") Then
                    local64 = createpropobj(("GFX\Map\Props\" + local63), local5)
                    local64\Field2 = readfloat(local0)
                    local64\Field3 = readfloat(local0)
                    local64\Field4 = readfloat(local0)
                    local64\Field8 = readfloat(local0)
                    local64\Field9 = readfloat(local0)
                    local64\Field10 = readfloat(local0)
                    local64\Field5 = readfloat(local0)
                    local64\Field6 = readfloat(local0)
                    local64\Field7 = readfloat(local0)
                    local64\Field11 = arg1
                Else
                    local18 = readfloat(local0)
                    local19 = readfloat(local0)
                    local20 = readfloat(local0)
                    createconsolemsg(((((("model.load.error | " + (Str local18)) + ", ") + (Str local19)) + ", ") + (Str local20)), $FF, $FF, $00, $00)
                EndIf
        End Select
    Next
    local66 = copymesh(local9, $00)
    flipmesh(local66)
    addmesh(local66, local9)
    freeentity(local66)
    If (local13 <> $00) Then
        freebrush(local13)
    EndIf
    addmesh(local9, local8)
    freeentity(local9)
    entityfx(local8, $03)
    entityalpha(local36, 0.0)
    entityalpha(local8, 1.0)
    entitytype(local36, $01, $00)
    local65 = createpivot($00)
    createpivot(local65)
    entityparent(local8, local65, $01)
    entityparent(local36, local65, $01)
    createpivot(local65)
    createpivot(local65)
    entityparent(local1, local65, $01)
    closefile(local0)
    Return local65
    Return $00
End Function
