Function loadworld%(arg0$, arg1.roomtemplates)
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12$
    Local local14.tempscreens
    Local local15.tempwaypoints
    Local local16#
    Local local17$
    Local local18#
    Local local19%
    Local local20%
    Local local21%
    Local local22.lighttemplates
    Local local23$
    Local local24#
    Local local25#
    Local local26#
    Local local27%
    local0 = loadanimmesh_strict(arg0, $00)
    If (local0 = $00) Then
        Return $00
    EndIf
    local7 = createpivot($00)
    local8 = createpivot(local7)
    local9 = createmesh(local7)
    local10 = createpivot(local7)
    entitytype(local10, $01, $00)
    For local5 = $01 To countchildren(local0) Step $01
        local11 = getchild(local0, local5)
        local12 = lower(keyvalue(local11, "classname", ""))
        Select local12
            Case "mesh"
                entityparent(local11, local8, $01)
                If (keyvalue(local11, "disablecollisions", "") <> "1") Then
                    entitytype(local11, $01, $00)
                    entitypickmode(local11, $02, $01)
                EndIf
                local5 = (local5 - $01)
            Case "brush"
                rotatemesh(local11, entitypitch(local11, $00), entityyaw(local11, $00), entityroll(local11, $00))
                positionmesh(local11, entityx(local11, $00), entityy(local11, $00), entityz(local11, $00))
                addmesh(local11, local9)
                entityalpha(local11, 0.0)
                entitytype(local11, $01, $00)
                entityalpha(local11, 0.0)
                entityparent(local11, local10, $01)
                entitypickmode(local11, $02, $01)
                local5 = (local5 - $01)
            Case "item"
            Case "screen"
                local1 = (entityx(local11, $00) * roomscale)
                local2 = (entityy(local11, $00) * roomscale)
                local3 = (entityz(local11, $00) * roomscale)
                If ((((0.0 <> local1) Or (0.0 <> local2)) Or (0.0 <> local3)) <> 0) Then
                    local14 = (New tempscreens)
                    local14\Field1 = local1
                    local14\Field2 = local2
                    local14\Field3 = local3
                    local14\Field0 = keyvalue(local11, "imgpath", "")
                    local14\Field4 = arg1
                EndIf
            Case "waypoint"
                local1 = (entityx(local11, $00) * roomscale)
                local2 = (entityy(local11, $00) * roomscale)
                local3 = (entityz(local11, $00) * roomscale)
                local15 = (New tempwaypoints)
                local15\Field3 = arg1
                local15\Field0 = local1
                local15\Field1 = local2
                local15\Field2 = local3
            Case "light"
                local1 = (entityx(local11, $00) * roomscale)
                local2 = (entityy(local11, $00) * roomscale)
                local3 = (entityz(local11, $00) * roomscale)
                If ((((0.0 <> local1) Or (0.0 <> local2)) Or (0.0 <> local3)) <> 0) Then
                    local16 = ((Float keyvalue(local11, "range", "1")) / 2000.0)
                    local17 = keyvalue(local11, "color", "255 255 255")
                    local18 = min(((Float keyvalue(local11, "intensity", "1.0")) * 0.8), 1.0)
                    local19 = (Int ((Float (Int piece(local17, $01, " "))) * local18))
                    local20 = (Int ((Float (Int piece(local17, $02, " "))) * local18))
                    local21 = (Int ((Float (Int piece(local17, $03, " "))) * local18))
                    addtemplight(arg1, local1, local2, local3, $02, local16, local19, local20, local21)
                EndIf
            Case "spotlight"
                local1 = (entityx(local11, $00) * roomscale)
                local2 = (entityy(local11, $00) * roomscale)
                local3 = (entityz(local11, $00) * roomscale)
                If ((((0.0 <> local1) Or (0.0 <> local2)) Or (0.0 <> local3)) <> 0) Then
                    local16 = ((Float keyvalue(local11, "range", "1")) / 700.0)
                    local17 = keyvalue(local11, "color", "255 255 255")
                    local18 = min(((Float keyvalue(local11, "intensity", "1.0")) * 0.8), 1.0)
                    local19 = (Int ((Float (Int piece(local17, $01, " "))) * local18))
                    local20 = (Int ((Float (Int piece(local17, $02, " "))) * local18))
                    local21 = (Int ((Float (Int piece(local17, $03, " "))) * local18))
                    local22 = addtemplight(arg1, local1, local2, local3, $03, local16, local19, local20, local21)
                    local23 = keyvalue(local11, "angles", "0 0 0")
                    local24 = (Float piece(local23, $01, " "))
                    local25 = (Float piece(local23, $02, " "))
                    local22\Field9 = local24
                    local22\Field10 = local25
                    local22\Field11 = (Int keyvalue(local11, "innerconeangle", ""))
                    local22\Field12 = (Float (Int keyvalue(local11, "outerconeangle", "")))
                EndIf
            Case "soundemitter"
                For local4 = $00 To $03 Step $01
                    If (arg1\Field4[local4] = $00) Then
                        arg1\Field5[local4] = (entityx(local11, $00) * roomscale)
                        arg1\Field6[local4] = (entityy(local11, $00) * roomscale)
                        arg1\Field7[local4] = (entityz(local11, $00) * roomscale)
                        arg1\Field4[local4] = (Int keyvalue(local11, "sound", "0"))
                        arg1\Field8[local4] = (Float keyvalue(local11, "range", "1"))
                        Exit
                    EndIf
                Next
            Case "field_hit"
                entityparent(local11, local10, $01)
                entitytype(local11, $01, $00)
                entityalpha(local11, 0.0)
                local5 = (local5 - $01)
            Case "playerstart"
                local23 = keyvalue(local11, "angles", "0 0 0")
                local24 = (Float piece(local23, $01, " "))
                local25 = (Float piece(local23, $02, " "))
                local26 = (Float piece(local23, $03, " "))
                If (local27 <> 0) Then
                    positionentity(local27, entityx(local11, $00), entityy(local11, $00), entityz(local11, $00), $00)
                    rotateentity(local27, local24, local25, local26, $00)
                EndIf
        End Select
    Next
    entityfx(local9, $01)
    freeentity(local0)
    Return local7
    Return $00
End Function
