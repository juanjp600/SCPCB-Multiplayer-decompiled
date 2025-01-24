Function loadrmesh%(arg0$, arg1.roomtemplates, arg2%)
    Local local0%
    Local local1.materials
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    Local local6#
    Local local7#
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12$
    Local local13%
    Local local14$
    Local local15$
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local20%[2]
    Local local21%
    Local local22%
    Local local23#
    Local local24#
    Local local25%
    Local local26%
    Local local27%
    Local local28$
    Local local29%
    Local local30%
    Local local31.tempscreens
    Local local32.tempwaypoints
    Local local33.templights
    Local local34.tempsoundemitters
    Local local35.tempprops
    Local local36%
    Local local37$
    Local local38#
    Local local39%
    Local local40%
    Local local41%
    Local local42$
    Local local43$
    Local local45%
    catcherrors((("LoadRMesh(" + arg0) + ")"))
    local0 = readfile_strict(arg0)
    If (local0 = $00) Then
        runtimeerrorex(format(getlocalstring("runerr", "file"), arg0, "%s"))
    EndIf
    clscolor($00, $00, $00)
    local9 = $00
    local10 = $00
    local11 = $00
    local13 = createpivot($00)
    local14 = readstring(local0)
    If (local14 <> "RoomMesh") Then
        runtimeerrorex(format(format(getlocalstring("runerr", "notrmesh"), arg0, "{0}"), local14, "{1}"))
    EndIf
    local15 = stripfilename(arg0)
    local16 = createmesh($00)
    local17 = createmesh($00)
    local25 = readint(local0)
    For local2 = $01 To local25 Step $01
        local18 = createmesh($00)
        local19 = createsurface(local18, $00)
        local21 = createbrush(255.0, 255.0, 255.0)
        local20[$00] = $00
        local20[$01] = $00
        local22 = $00
        For local3 = $00 To $01 Step $01
            local9 = readbyte(local0)
            If (local9 <> $00) Then
                local12 = readstring(local0)
                If (filetype((local15 + local12)) = $01) Then
                    If (local9 < $03) Then
                        If (instr(lower(local12), "_lm", $01) <> $00) Then
                            local20[local3] = loadtexturecheckingifincache((local15 + local12), ((opt\Field3 Shl $08) + $01), $00)
                        Else
                            local20[local3] = loadtexturecheckingifincache((local15 + local12), $01, $00)
                        EndIf
                    Else
                        local20[local3] = loadtexturecheckingifincache((local15 + local12), $03, $00)
                    EndIf
                ElseIf (filetype(("GFX\Map\Textures\" + local12)) = $01) Then
                    If (local9 < $03) Then
                        If (instr(lower(local12), "_lm", $01) <> $00) Then
                            local20[local3] = loadtexturecheckingifincache(("GFX\Map\Textures\" + local12), ((opt\Field3 Shl $08) + $01), $00)
                        Else
                            local20[local3] = loadtexturecheckingifincache(("GFX\Map\Textures\" + local12), $01, $00)
                        EndIf
                    Else
                        local20[local3] = loadtexturecheckingifincache(("GFX\Map\Textures\" + local12), $03, $00)
                    EndIf
                EndIf
                If (local20[local3] <> $00) Then
                    If (local9 = $01) Then
                        textureblend(local20[local3], $05)
                    EndIf
                    If (instr(lower(local12), "_lm", $01) <> $00) Then
                        textureblend(local20[local3], $03)
                    EndIf
                    local22 = $02
                    If (local9 = $03) Then
                        local22 = $01
                    EndIf
                    texturecoords(local20[local3], ($01 - local3))
                EndIf
            EndIf
        Next
        If (local22 = $01) Then
            If (local20[$01] <> $00) Then
                textureblend(local20[$01], $02)
                brushtexture(local21, local20[$01], $00, $00)
            Else
                brushtexture(local21, missingtexture, $00, $00)
            EndIf
        Else
            local27 = $00
            If (((local20[$00] <> $00) And (local20[$01] <> $00)) <> 0) Then
                If (opt\Field2 <> 0) Then
                    local28 = strippath(texturename(local20[$01]))
                    For local1 = Each materials
                        If (local1\Field0 = local28) Then
                            local27 = local1\Field1
                            Exit
                        EndIf
                    Next
                Else
                    local27 = $00
                EndIf
                If (local27 = $00) Then
                    For local3 = $00 To $01 Step $01
                        brushtexture(local21, local20[local3], $00, (local3 + $01))
                    Next
                Else
                    texturecoords(local27, $00)
                    For local3 = $00 To $01 Step $01
                        brushtexture(local21, local20[local3], $00, (local3 + $02))
                    Next
                    brushtexture(local21, local27, $00, $01)
                EndIf
                brushtexture(local21, ambientlightroomtex, $00, $00)
            Else
                If (opt\Field2 <> 0) Then
                    If (local20[$01] <> $00) Then
                        local28 = strippath(texturename(local20[$01]))
                        For local1 = Each materials
                            If (local1\Field0 = local28) Then
                                local27 = local1\Field1
                                Exit
                            EndIf
                        Next
                    EndIf
                Else
                    local27 = $00
                EndIf
                If (local27 = $00) Then
                    For local3 = $00 To $01 Step $01
                        If (local20[local3] <> $00) Then
                            brushtexture(local21, local20[local3], $00, local3)
                        Else
                            brushtexture(local21, missingtexture, $00, local3)
                        EndIf
                    Next
                Else
                    texturecoords(local27, $00)
                    For local3 = $00 To $01 Step $01
                        If (local20[local3] <> $00) Then
                            brushtexture(local21, local20[local3], $00, (local3 + $01))
                        Else
                            brushtexture(local21, missingtexture, $00, (local3 + $01))
                        EndIf
                    Next
                    brushtexture(local21, local27, $00, $00)
                EndIf
            EndIf
        EndIf
        local19 = createsurface(local18, $00)
        If (local22 > $00) Then
            paintsurface(local19, local21)
        EndIf
        freebrush(local21)
        local21 = $00
        local26 = readint(local0)
        For local3 = $01 To local26 Step $01
            local5 = readfloat(local0)
            local6 = readfloat(local0)
            local7 = readfloat(local0)
            local8 = addvertex(local19, local5, local6, local7, 0.0, 0.0, 1.0)
            For local4 = $00 To $01 Step $01
                local23 = readfloat(local0)
                local24 = readfloat(local0)
                vertextexcoords(local19, local8, local23, local24, 0.0, local4)
            Next
            local9 = readbyte(local0)
            local10 = readbyte(local0)
            local11 = readbyte(local0)
            vertexcolor(local19, local8, (Float local9), (Float local10), (Float local11), 1.0)
        Next
        local26 = readint(local0)
        For local3 = $01 To local26 Step $01
            local9 = readint(local0)
            local10 = readint(local0)
            local11 = readint(local0)
            addtriangle(local19, local9, local10, local11)
        Next
        If (local22 = $01) Then
            addmesh(local18, local17)
            entityalpha(local18, 0.0)
        Else
            addmesh(local18, local16)
            entityparent(local18, local13, $01)
            entityalpha(local18, 0.0)
            entitytype(local18, arg2, $00)
            entitypickmode(local18, $02, $01)
            If (arg2 <> 0) Then
                local29 = copymesh(local18, $00)
                flipmesh(local29)
                addmesh(local29, local18)
                freeentity(local29)
                local29 = $00
            EndIf
        EndIf
    Next
    local30 = createmesh($00)
    local25 = readint(local0)
    For local2 = $01 To local25 Step $01
        local19 = createsurface(local30, $00)
        local26 = readint(local0)
        For local3 = $01 To local26 Step $01
            local5 = readfloat(local0)
            local6 = readfloat(local0)
            local7 = readfloat(local0)
            local8 = addvertex(local19, local5, local6, local7, 0.0, 0.0, 1.0)
        Next
        local26 = readint(local0)
        For local3 = $01 To local26 Step $01
            local9 = readint(local0)
            local10 = readint(local0)
            local11 = readint(local0)
            addtriangle(local19, local9, local10, local11)
            addtriangle(local19, local9, local11, local10)
        Next
    Next
    local25 = readint(local0)
    If (arg1 <> Null) Then
        For local2 = $01 To local25 Step $01
            local12 = readstring(local0)
            Select local12
                Case "screen"
                    local31 = (New tempscreens)
                    local31\Field4 = arg1
                    local31\Field1 = (readfloat(local0) * (1.0 / 256.0))
                    local31\Field2 = (readfloat(local0) * (1.0 / 256.0))
                    local31\Field3 = (readfloat(local0) * (1.0 / 256.0))
                    local43 = readstring(local0)
                    local31\Field0 = local43
                Case "waypoint"
                    local32 = (New tempwaypoints)
                    local32\Field3 = arg1
                    local32\Field0 = (readfloat(local0) * (1.0 / 256.0))
                    local32\Field1 = (readfloat(local0) * (1.0 / 256.0))
                    local32\Field2 = (readfloat(local0) * (1.0 / 256.0))
                Case "light"
                    local33 = (New templights)
                    local33\Field0 = arg1
                    local33\Field2 = (readfloat(local0) * (1.0 / 256.0))
                    local33\Field3 = (readfloat(local0) * (1.0 / 256.0))
                    local33\Field4 = (readfloat(local0) * (1.0 / 256.0))
                    local33\Field1 = $02
                    local33\Field5 = (readfloat(local0) / 2000.0)
                    local37 = readstring(local0)
                    local38 = min((readfloat(local0) * 0.8), 1.0)
                    local33\Field6 = (Int ((Float (Int piece(local37, $01, " "))) * local38))
                    local33\Field7 = (Int ((Float (Int piece(local37, $02, " "))) * local38))
                    local33\Field8 = (Int ((Float (Int piece(local37, $03, " "))) * local38))
                    local33\Field13 = $01
                Case "light_fix"
                    local33 = (New templights)
                    local33\Field0 = arg1
                    local33\Field2 = (readfloat(local0) * (1.0 / 256.0))
                    local33\Field3 = (readfloat(local0) * (1.0 / 256.0))
                    local33\Field4 = (readfloat(local0) * (1.0 / 256.0))
                    local33\Field1 = $02
                    local37 = readstring(local0)
                    local38 = min((readfloat(local0) * 0.8), 1.0)
                    local33\Field5 = (readfloat(local0) / 2000.0)
                    local33\Field6 = (Int ((Float (Int piece(local37, $01, " "))) * local38))
                    local33\Field7 = (Int ((Float (Int piece(local37, $02, " "))) * local38))
                    local33\Field8 = (Int ((Float (Int piece(local37, $03, " "))) * local38))
                    local33\Field13 = $00
                Case "spotlight"
                    local33 = (New templights)
                    local33\Field0 = arg1
                    local33\Field2 = (readfloat(local0) * (1.0 / 256.0))
                    local33\Field3 = (readfloat(local0) * (1.0 / 256.0))
                    local33\Field4 = (readfloat(local0) * (1.0 / 256.0))
                    local33\Field1 = $03
                    local33\Field5 = (readfloat(local0) / 2000.0)
                    local37 = readstring(local0)
                    local38 = min((readfloat(local0) * 0.8), 1.0)
                    local33\Field6 = (Int ((Float (Int piece(local37, $01, " "))) * local38))
                    local33\Field7 = (Int ((Float (Int piece(local37, $02, " "))) * local38))
                    local33\Field8 = (Int ((Float (Int piece(local37, $03, " "))) * local38))
                    local42 = readstring(local0)
                    local33\Field9 = (Float piece(local42, $01, " "))
                    local33\Field10 = (Float piece(local42, $02, " "))
                    local33\Field11 = readint(local0)
                    local33\Field12 = (Float readint(local0))
                Case "soundemitter"
                    local34 = (New tempsoundemitters)
                    local34\Field5 = arg1
                    local34\Field0 = (readfloat(local0) * (1.0 / 256.0))
                    local34\Field1 = (readfloat(local0) * (1.0 / 256.0))
                    local34\Field2 = (readfloat(local0) * (1.0 / 256.0))
                    local34\Field3 = readint(local0)
                    local34\Field4 = readfloat(local0)
                Case "model"
                    local43 = readstring(local0)
                    runtimeerrorex(format(format(getlocalstring("runerr", "model.support"), arg1\Field5, "{0}"), ("GFX\Map\Props\" + local43), "{1}"))
                Case "mesh"
                    local35 = (New tempprops)
                    local35\Field13 = arg1
                    local35\Field1 = (readfloat(local0) * (1.0 / 256.0))
                    local35\Field2 = (readfloat(local0) * (1.0 / 256.0))
                    local35\Field3 = (readfloat(local0) * (1.0 / 256.0))
                    local43 = readstring(local0)
                    If (fileextension(local43) = "b3d") Then
                        local43 = left(local43, (len(local43) - $04))
                    EndIf
                    local35\Field0 = (("GFX\Map\Props\" + local43) + ".b3d")
                    local35\Field4 = readfloat(local0)
                    local35\Field5 = readfloat(local0)
                    local35\Field6 = readfloat(local0)
                    local35\Field7 = readfloat(local0)
                    local35\Field8 = readfloat(local0)
                    local35\Field9 = readfloat(local0)
                    local35\Field10 = readbyte(local0)
                    local35\Field11 = readint(local0)
                    local35\Field12 = readstring(local0)
            End Select
        Next
    EndIf
    local9 = copymesh(local17, $00)
    flipmesh(local9)
    addmesh(local9, local17)
    freeentity(local9)
    local9 = $00
    If (local21 <> $00) Then
        freebrush(local21)
        local21 = $00
    EndIf
    addmesh(local17, local16)
    freeentity(local17)
    local17 = $00
    entityfx(local16, $03)
    entityalpha(local30, 0.0)
    entitytype(local30, arg2, $00)
    entityalpha(local16, 1.0)
    local45 = createpivot($00)
    createpivot(local45)
    entityparent(local16, local45, $01)
    entityparent(local30, local45, $01)
    createpivot(local45)
    createpivot(local45)
    entityparent(local13, local45, $01)
    closefile(local0)
    catcherrors((("Uncaught: LoadRMesh(" + arg0) + ")"))
    Return local45
    Return $00
End Function
