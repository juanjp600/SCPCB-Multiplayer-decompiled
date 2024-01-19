Function loadrmesh%(arg0$, arg1.roomtemplates)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14#
    Local local15#
    Local local16#
    Local local17$
    Local local18$
    Local local19%
    Local local20%
    Local local21$
    Local local22%
    Local local23%
    Local local24%
    Local local25%
    Local local26%
    Local local27%
    Local local28%[2]
    Local local29%
    Local local30%
    Local local31#
    Local local32#
    Local local33%
    Local local34%
    Local local35%
    Local local36%
    Local local38.tempscreens
    Local local39.tempwaypoints
    Local local40#
    Local local41$
    Local local42#
    Local local43%
    Local local44%
    Local local45%
    Local local46.lighttemplates
    Local local47$
    Local local48#
    Local local49#
    Local local50%
    Local local51.props
    Local local52%
    local0 = createtexture($04, $04, $01, $01)
    clscolor($FF, $FF, $FF)
    setbuffer(texturebuffer(local0, $00))
    cls()
    setbuffer(backbuffer())
    local1 = createtexture($04, $04, $01, $01)
    clscolor($FF, $FF, $FF)
    setbuffer(texturebuffer(local1, $00))
    cls()
    setbuffer(backbuffer())
    clscolor($00, $00, $00)
    local2 = readfile(arg0)
    local19 = createpivot($00)
    local20 = $00
    For local3 = $00 To $03 Step $01
        If (local2 = $00) Then
            local2 = readfile(arg0)
        Else
            Exit
        EndIf
    Next
    If (local2 = $00) Then
        runtimeerror(((("Error reading file " + chr($22)) + arg0) + chr($22)))
    EndIf
    local21 = readstring(local2)
    If (local21 <> "RoomMesh") Then
        If (local21 = "RoomMesh.HasTriggerBox") Then
            local20 = $01
        Else
            runtimeerror((((((chr($22) + arg0) + chr($22)) + " is Not RMESH (") + local21) + ")"))
        EndIf
    EndIf
    arg0 = stripfilename(arg0)
    local24 = createmesh($00)
    local25 = createmesh($00)
    local22 = readint(local2)
    For local3 = $01 To local22 Step $01
        local26 = createmesh($00)
        local27 = createsurface(local26, $00)
        local29 = createbrush(255.0, 255.0, 255.0)
        local28[$00] = $00
        local28[$01] = $00
        local30 = $00
        For local4 = $00 To $01 Step $01
            local11 = readbyte(local2)
            If (local11 <> $00) Then
                local17 = readstring(local2)
                local28[local4] = gettexturefromcache(local17)
                If (local28[local4] = $00) Then
                    local33 = $01
                    If (local33 <> (local11 < $03)) Then
                        local28[local4] = loadtexture_strict((arg0 + local17), $03)
                    Else
                        local28[local4] = loadtexture_strict((arg0 + local17), $01)
                    EndIf
                    If (local28[local4] <> $00) Then
                        addtexturetocache(local28[local4])
                    EndIf
                EndIf
                If (local28[local4] <> $00) Then
                    local30 = $02
                    If (local11 = $03) Then
                        local30 = $01
                    EndIf
                EndIf
            EndIf
        Next
        local27 = createsurface(local26, $00)
        If (local30 > $00) Then
            paintsurface(local27, local29)
        EndIf
        freebrush(local29)
        local29 = $00
        local23 = readint(local2)
        For local4 = $01 To local23 Step $01
            local6 = readfloat(local2)
            local7 = readfloat(local2)
            local8 = readfloat(local2)
            local10 = addvertex(local27, local6, local7, local8, 0.0, 0.0, 1.0)
            For local5 = $00 To $01 Step $01
                local31 = readfloat(local2)
                local32 = readfloat(local2)
                vertextexcoords(local27, local10, local31, local32, 0.0, local5)
            Next
            local11 = readbyte(local2)
            local12 = readbyte(local2)
            local13 = readbyte(local2)
            vertexcolor(local27, local10, (Float local11), (Float local12), (Float local13), 1.0)
        Next
        local23 = readint(local2)
        For local4 = $01 To local23 Step $01
            local11 = readint(local2)
            local12 = readint(local2)
            local13 = readint(local2)
            addtriangle(local27, local11, local12, local13)
        Next
        If (local30 = $01) Then
            addmesh(local26, local25)
            entityalpha(local26, 0.0)
        Else
            addmesh(local26, local24)
            entityparent(local26, local19, $01)
            entityalpha(local26, 0.0)
            entitytype(local26, $01, $00)
            entitypickmode(local26, $02, $01)
            local34 = copymesh(local26, $00)
            flipmesh(local34)
            addmesh(local34, local26)
            freeentity(local34)
        EndIf
        For local4 = $00 To $01 Step $01
            If (local28[local4] <> $00) Then
                If (((lower(strippath(texturename(local28[local4]))) = "glass.png") Xor (lower(strippath(texturename(local28[local4]))) = "matglass.png")) <> 0) Then
                    addmesh(local26, local24)
                    entityparent(local26, local19, $01)
                    entitytype(local26, $01, $00)
                    entitypickmode(local26, $02, $01)
                    local34 = copymesh(local26, $00)
                    flipmesh(local34)
                    addmesh(local34, local26)
                    freeentity(local34)
                EndIf
            EndIf
        Next
    Next
    local35 = createmesh($00)
    local22 = readint(local2)
    For local3 = $01 To local22 Step $01
        local27 = createsurface(local35, $00)
        local23 = readint(local2)
        For local4 = $01 To local23 Step $01
            local6 = readfloat(local2)
            local7 = readfloat(local2)
            local8 = readfloat(local2)
            local10 = addvertex(local27, local6, local7, local8, 0.0, 0.0, 1.0)
        Next
        local23 = readint(local2)
        For local4 = $01 To local23 Step $01
            local11 = readint(local2)
            local12 = readint(local2)
            local13 = readint(local2)
            addtriangle(local27, local11, local12, local13)
            addtriangle(local27, local11, local13, local12)
        Next
    Next
    If (local20 <> 0) Then
        debuglog("TriggerBoxEnable")
        arg1\Field14 = readint(local2)
        For local36 = $00 To (arg1\Field14 - $01) Step $01
            arg1\Field15[local36] = createmesh(arg1\Field0)
            local22 = readint(local2)
            For local3 = $01 To local22 Step $01
                local27 = createsurface(arg1\Field15[local36], $00)
                local23 = readint(local2)
                For local4 = $01 To local23 Step $01
                    local6 = readfloat(local2)
                    local7 = readfloat(local2)
                    local8 = readfloat(local2)
                    local10 = addvertex(local27, local6, local7, local8, 0.0, 0.0, 1.0)
                Next
                local23 = readint(local2)
                For local4 = $01 To local23 Step $01
                    local11 = readint(local2)
                    local12 = readint(local2)
                    local13 = readint(local2)
                    addtriangle(local27, local11, local12, local13)
                    addtriangle(local27, local11, local13, local12)
                Next
            Next
            arg1\Field16[local36] = readstring(local2)
        Next
    EndIf
    local22 = readint(local2)
    For local3 = $01 To local22 Step $01
        local17 = readstring(local2)
        Select local17
            Case "screen"
                local14 = (readfloat(local2) * roomscale)
                local15 = (readfloat(local2) * roomscale)
                local16 = (readfloat(local2) * roomscale)
                local18 = readstring(local2)
                If ((((0.0 <> local14) Or (0.0 <> local15)) Or (0.0 <> local16)) <> 0) Then
                    local38 = (New tempscreens)
                    local38\Field1 = local14
                    local38\Field2 = local15
                    local38\Field3 = local16
                    local38\Field0 = local18
                    local38\Field4 = arg1
                EndIf
            Case "waypoint"
                local14 = (readfloat(local2) * roomscale)
                local15 = (readfloat(local2) * roomscale)
                local16 = (readfloat(local2) * roomscale)
                local39 = (New tempwaypoints)
                local39\Field3 = arg1
                local39\Field0 = local14
                local39\Field1 = local15
                local39\Field2 = local16
            Case "light"
                local14 = (readfloat(local2) * roomscale)
                local15 = (readfloat(local2) * roomscale)
                local16 = (readfloat(local2) * roomscale)
                If ((((0.0 <> local14) Or (0.0 <> local15)) Or (0.0 <> local16)) <> 0) Then
                    local40 = (readfloat(local2) / 2000.0)
                    local41 = readstring(local2)
                    local42 = min((readfloat(local2) * 0.8), 1.0)
                    local43 = (Int ((Float (Int piece(local41, $01, " "))) * local42))
                    local44 = (Int ((Float (Int piece(local41, $02, " "))) * local42))
                    local45 = (Int ((Float (Int piece(local41, $03, " "))) * local42))
                    addtemplight(arg1, local14, local15, local16, $02, local40, local43, local44, local45)
                Else
                    readfloat(local2)
                    readstring(local2)
                    readfloat(local2)
                EndIf
            Case "spotlight"
                local14 = (readfloat(local2) * roomscale)
                local15 = (readfloat(local2) * roomscale)
                local16 = (readfloat(local2) * roomscale)
                If ((((0.0 <> local14) Or (0.0 <> local15)) Or (0.0 <> local16)) <> 0) Then
                    local40 = (readfloat(local2) / 2000.0)
                    local41 = readstring(local2)
                    local42 = min((readfloat(local2) * 0.8), 1.0)
                    local43 = (Int ((Float (Int piece(local41, $01, " "))) * local42))
                    local44 = (Int ((Float (Int piece(local41, $02, " "))) * local42))
                    local45 = (Int ((Float (Int piece(local41, $03, " "))) * local42))
                    local46 = addtemplight(arg1, local14, local15, local16, $02, local40, local43, local44, local45)
                    local47 = readstring(local2)
                    local48 = (Float piece(local47, $01, " "))
                    local9 = (Float piece(local47, $02, " "))
                    local46\Field9 = local48
                    local46\Field10 = local9
                    local46\Field11 = readint(local2)
                    local46\Field12 = (Float readint(local2))
                Else
                    readfloat(local2)
                    readstring(local2)
                    readfloat(local2)
                    readstring(local2)
                    readint(local2)
                    readint(local2)
                EndIf
            Case "soundemitter"
                local11 = $00
                For local4 = $00 To $07 Step $01
                    If (arg1\Field4[local4] = $00) Then
                        arg1\Field5[local4] = (readfloat(local2) * roomscale)
                        arg1\Field6[local4] = (readfloat(local2) * roomscale)
                        arg1\Field7[local4] = (readfloat(local2) * roomscale)
                        arg1\Field4[local4] = readint(local2)
                        arg1\Field8[local4] = readfloat(local2)
                        local11 = $01
                        Exit
                    EndIf
                Next
                If (local11 = $00) Then
                    readfloat(local2)
                    readfloat(local2)
                    readfloat(local2)
                    readint(local2)
                    readfloat(local2)
                EndIf
            Case "playerstart"
                local14 = readfloat(local2)
                local15 = readfloat(local2)
                local16 = readfloat(local2)
                local47 = readstring(local2)
                local48 = (Float piece(local47, $01, " "))
                local9 = (Float piece(local47, $02, " "))
                local49 = (Float piece(local47, $03, " "))
                If (local50 <> 0) Then
                    positionentity(local50, local14, local15, local16, $00)
                    rotateentity(local50, local48, local9, local49, $00)
                EndIf
            Case "model"
                arg0 = readstring(local2)
                If (arg0 <> "") Then
                    local51 = createpropobj(("GFX\Map\Props\" + arg0))
                    local51\Field2 = readfloat(local2)
                    local51\Field3 = readfloat(local2)
                    local51\Field4 = readfloat(local2)
                    local51\Field8 = readfloat(local2)
                    local51\Field9 = readfloat(local2)
                    local51\Field10 = readfloat(local2)
                    local51\Field5 = readfloat(local2)
                    local51\Field6 = readfloat(local2)
                    local51\Field7 = readfloat(local2)
                    local51\Field11 = arg1
                Else
                    debuglog("file = 0")
                    local14 = readfloat(local2)
                    local15 = readfloat(local2)
                    local16 = readfloat(local2)
                    debuglog((((((Str local14) + ", ") + (Str local15)) + ", ") + (Str local16)))
                EndIf
        End Select
    Next
    local11 = copymesh(local25, $00)
    flipmesh(local11)
    addmesh(local11, local25)
    freeentity(local11)
    If (local29 <> $00) Then
        freebrush(local29)
    EndIf
    addmesh(local25, local24)
    freeentity(local25)
    entityfx(local24, $03)
    entityalpha(local35, 0.0)
    entityalpha(local24, 1.0)
    entitytype(local35, $01, $00)
    freetexture(local0)
    local52 = createpivot($00)
    createpivot(local52)
    entityparent(local24, local52, $01)
    entityparent(local35, local52, $01)
    createpivot(local52)
    createpivot(local52)
    entityparent(local19, local52, $01)
    closefile(local2)
    Return local52
    Return $00
End Function
