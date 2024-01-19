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
    Local local9#
    Local local10#
    Local local11%
    Local local12%
    Local local13#
    debuglog(("load_terrain: " + (Str arg0)))
    If (arg0 = $00) Then
        runtimeerror((("Heightmap image " + (Str arg0)) + " does not exist."))
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
    If (arg2 <> 0) Then
        scaletexture(arg2, (Float (local0 Sar $02)), (Float (local1 Sar $02)))
    EndIf
    If (arg3 <> 0) Then
        scaletexture(arg3, (Float (local0 Sar $02)), (Float (local1 Sar $02)))
    EndIf
    If (arg4 <> 0) Then
        scaletexture(arg4, (Float local0), (Float local1))
    EndIf
    local5 = createmesh($00)
    local6 = createsurface(local5, $00)
    For local3 = $00 To local1 Step $01
        For local2 = $00 To local0 Step $01
            addvertex(local6, (Float local2), 0.0, (Float local3), (1.0 / (Float local2)), (1.0 / (Float local3)), 1.0)
        Next
    Next
    renderworld(1.0)
    For local3 = $00 To (local1 - $01) Step $01
        For local2 = $00 To (local0 - $01) Step $01
            addtriangle(local6, (((local0 + $01) * local3) + local2), ((((local0 + $01) * local3) + local2) + (local0 + $01)), ((local2 + $01) + ((local0 + $01) * local3)))
            addtriangle(local6, ((local2 + $01) + ((local0 + $01) * local3)), ((((local0 + $01) * local3) + local2) + (local0 + $01)), (((local2 + $01) + ((local0 + $01) * local3)) + (local0 + $01)))
        Next
    Next
    local7 = copymesh(local5, local5)
    local8 = getsurface(local7, $01)
    positionmesh(local5, ((Float (- local0)) / 2.0), 0.0, ((Float (- local1)) / 2.0))
    positionmesh(local7, ((Float (- local0)) / 2.0), 0.01, ((Float (- local1)) / 2.0))
    lockbuffer(imagebuffer(arg0, $00))
    lockbuffer(texturebuffer(arg4, $00))
    For local2 = $00 To local0 Step $01
        For local3 = $00 To local1 Step $01
            local9 = min((((Float local2) * (Float texturewidth(arg4))) / (Float imagewidth(arg0))), (Float (texturewidth(arg4) - $01)))
            local10 = ((Float textureheight(arg4)) - min((((Float local3) * (Float textureheight(arg4))) / (Float imageheight(arg0))), (Float (textureheight(arg4) - $01))))
            local11 = readpixelfast((Int min((Float local2), (Float (local0 - $01)))), (Int ((Float local1) - min((Float local3), (Float (local1 - $01))))), imagebuffer(arg0, $00))
            local12 = ((local11 And $FF0000) Shr $10)
            local13 = (Float (((readpixelfast((Int max((local9 - 5.0), 5.0)), (Int max((local10 - 5.0), 5.0)), texturebuffer(arg4, $00)) And $FF000000) Shr $18) / $FF))
            local13 = ((Float (((readpixelfast((Int min((local9 + 5.0), (Float (texturewidth(arg4) - $05)))), (Int min((local10 + 5.0), (Float (textureheight(arg4) - $05)))), texturebuffer(arg4, $00)) And $FF000000) Shr $18) / $FF)) + local13)
            local13 = ((Float (((readpixelfast((Int max((local9 - 5.0), 5.0)), (Int min((local10 + 5.0), (Float (textureheight(arg4) - $05)))), texturebuffer(arg4, $00)) And $FF000000) Shr $18) / $FF)) + local13)
            local13 = ((Float (((readpixelfast((Int min((local9 + 5.0), (Float (texturewidth(arg4) - $05)))), (Int max((local10 - 5.0), 5.0)), texturebuffer(arg4, $00)) And $FF000000) Shr $18) / $FF)) + local13)
            local13 = (local13 * 0.25)
            local13 = sqr(local13)
            local4 = (((local0 + $01) * local3) + local2)
            vertexcoords(local6, local4, vertexx(local6, local4), ((Float local12) * arg1), vertexz(local6, local4))
            vertexcoords(local8, local4, vertexx(local8, local4), ((Float local12) * arg1), vertexz(local8, local4))
            vertexcolor(local8, local4, 255.0, 255.0, 255.0, local13)
            vertextexcoords(local6, local4, (Float local2), (Float (- local3)), 1.0, $00)
            vertextexcoords(local8, local4, (Float local2), (Float (- local3)), 1.0, $00)
        Next
    Next
    unlockbuffer(texturebuffer(arg4, $00))
    unlockbuffer(imagebuffer(arg0, $00))
    updatenormals(local5)
    updatenormals(local7)
    entitytexture(local5, arg2, $00, $00)
    entitytexture(local7, arg3, $00, $00)
    entityfx(local5, $01)
    entityfx(local7, $23)
    Return local5
    Return $00
End Function
