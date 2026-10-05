Function load_terrain%(arg0%, arg1#, arg2%, arg3%, arg4%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11#
    Local local12#
    Local local13%
    Local local14%
    Local local15#
    If (arg0 = $00) Then
        runtimeerror((("Heightmap forest image " + (Str arg0)) + " does not exist."))
    EndIf
    local0 = (imagewidth(arg0) - $01)
    local1 = (imageheight(arg0) - $01)
    If (arg2 = $00) Then
        runtimeerror("load_terrain error: invalid texture 1")
    EndIf
    If (arg3 = $00) Then
        runtimeerror("load_terrain error: invalid texture 2")
    EndIf
    If (arg4 = $00) Then
        runtimeerror("load_terrain error: invalid texture mask")
    EndIf
    local5 = (Int ((Float local0) * 0.25))
    local6 = (Int ((Float local1) * 0.25))
    If (arg2 <> 0) Then
        scaletexture(arg2, (Float local5), (Float local6))
    EndIf
    If (arg3 <> 0) Then
        scaletexture(arg3, (Float local5), (Float local6))
    EndIf
    If (arg4 <> 0) Then
        scaletexture(arg4, (Float local0), (Float local1))
    EndIf
    local7 = createmesh($00)
    local8 = createsurface(local7, $00)
    For local3 = $00 To local1 Step $01
        For local2 = $00 To local0 Step $01
            addvertex(local8, (Float local2), 0.0, (Float local3), (1.0 / (Float local2)), (1.0 / (Float local3)), 1.0)
        Next
    Next
    For local3 = $00 To (local1 - $01) Step $01
        For local2 = $00 To (local0 - $01) Step $01
            addtriangle(local8, (((local0 + $01) * local3) + local2), ((((local0 + $01) * local3) + local2) + (local0 + $01)), ((local2 + $01) + ((local0 + $01) * local3)))
            addtriangle(local8, ((local2 + $01) + ((local0 + $01) * local3)), ((((local0 + $01) * local3) + local2) + (local0 + $01)), (((local2 + $01) + ((local0 + $01) * local3)) + (local0 + $01)))
        Next
    Next
    local9 = copymesh(local7, local7)
    local10 = getsurface(local9, $01)
    positionmesh(local7, ((Float (- local0)) * 0.5), 0.0, ((Float (- local1)) * 0.5))
    positionmesh(local9, ((Float (- local0)) * 0.5), 0.01, ((Float (- local1)) * 0.5))
    lockbuffer(imagebuffer(arg0, $00))
    lockbuffer(texturebuffer(arg4, $00))
    For local2 = $00 To local0 Step $01
        For local3 = $00 To local1 Step $01
            local11 = min((((Float local2) * (Float texturewidth(arg4))) / (Float imagewidth(arg0))), (Float (texturewidth(arg4) - $01)))
            local12 = ((Float textureheight(arg4)) - min((((Float local3) * (Float textureheight(arg4))) / (Float imageheight(arg0))), (Float (textureheight(arg4) - $01))))
            local13 = readpixelfast((Int min((Float local2), (Float (local0 - $01)))), (Int ((Float local1) - min((Float local3), (Float (local1 - $01))))), imagebuffer(arg0, $00))
            local14 = ((local13 And $FF0000) Shr $10)
            local15 = (Float (((readpixelfast((Int max((local11 - 5.0), 5.0)), (Int max((local12 - 5.0), 5.0)), texturebuffer(arg4, $00)) And $FF000000) Shr $18) / $FF))
            local15 = ((Float (((readpixelfast((Int min((local11 + 5.0), (Float (texturewidth(arg4) - $05)))), (Int min((local12 + 5.0), (Float (textureheight(arg4) - $05)))), texturebuffer(arg4, $00)) And $FF000000) Shr $18) / $FF)) + local15)
            local15 = ((Float (((readpixelfast((Int max((local11 - 5.0), 5.0)), (Int min((local12 + 5.0), (Float (textureheight(arg4) - $05)))), texturebuffer(arg4, $00)) And $FF000000) Shr $18) / $FF)) + local15)
            local15 = ((Float (((readpixelfast((Int min((local11 + 5.0), (Float (texturewidth(arg4) - $05)))), (Int max((local12 - 5.0), 5.0)), texturebuffer(arg4, $00)) And $FF000000) Shr $18) / $FF)) + local15)
            local15 = (local15 * 0.25)
            local15 = sqr(local15)
            local4 = (((local0 + $01) * local3) + local2)
            vertexcoords(local8, local4, vertexx(local8, local4), ((Float local14) * arg1), vertexz(local8, local4))
            vertexcoords(local10, local4, vertexx(local10, local4), ((Float local14) * arg1), vertexz(local10, local4))
            vertexcolor(local10, local4, 255.0, 255.0, 255.0, local15)
            vertextexcoords(local8, local4, (Float local2), (Float (- local3)), 1.0, $00)
            vertextexcoords(local10, local4, (Float local2), (Float (- local3)), 1.0, $00)
        Next
    Next
    unlockbuffer(texturebuffer(arg4, $00))
    unlockbuffer(imagebuffer(arg0, $00))
    updatenormals(local7)
    updatenormals(local9)
    entitytexture(local7, arg2, $00, $00)
    entitytexture(local9, arg3, $00, $00)
    entityfx(local7, $01)
    entityfx(local9, $23)
    Return local7
    Return $00
End Function
