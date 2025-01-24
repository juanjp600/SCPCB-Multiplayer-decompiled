Function loadterrain%(arg0%, arg1#, arg2%, arg3%, arg4%)
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
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15#
    Local local16#
    Local local17%
    Local local18%
    Local local19#
    If (arg0 = $00) Then
        runtimeerrorex(format(getlocalstring("runerr", "heightmap"), (Str arg0), "%s"))
    EndIf
    If (arg2 = $00) Then
        runtimeerrorex(format(getlocalstring("runerr", "tex_1"), (Str arg2), "%s"))
    EndIf
    If (arg3 = $00) Then
        runtimeerrorex(format(getlocalstring("runerr", "tex_2"), (Str arg3), "%s"))
    EndIf
    If (arg4 = $00) Then
        runtimeerrorex(format(getlocalstring("runerr", "mask"), (Str arg4), "%s"))
    EndIf
    local0 = (imagewidth(arg0) - $01)
    local1 = (imageheight(arg0) - $01)
    scaletexture(arg2, ((Float local0) / 4.0), ((Float local1) / 4.0))
    scaletexture(arg3, ((Float local0) / 4.0), ((Float local1) / 4.0))
    scaletexture(arg4, (Float local0), (Float local1))
    local5 = createmesh($00)
    local6 = createsurface(local5, $00)
    For local3 = $00 To local1 Step $01
        For local2 = $00 To local0 Step $01
            addvertex(local6, (Float local2), 0.0, (Float local3), (1.0 / (Float local2)), (1.0 / (Float local3)), 1.0)
        Next
    Next
    renderworld(1.0)
    local7 = (local0 + $01)
    For local3 = $00 To (local1 - $01) Step $01
        For local2 = $00 To (local0 - $01) Step $01
            local8 = ((local7 * local3) + local2)
            addtriangle(local6, local8, (local8 + local7), (local8 + $01))
            addtriangle(local6, (local8 + $01), (local8 + local7), ((local8 + local7) + $01))
        Next
    Next
    local9 = copymesh(local5, local5)
    local10 = getsurface(local9, $01)
    positionmesh(local5, ((Float (- local0)) / 2.0), 0.0, ((Float (- local1)) / 2.0))
    positionmesh(local9, ((Float (- local0)) / 2.0), 0.01, ((Float (- local1)) / 2.0))
    local11 = imagebuffer(arg0, $00)
    local12 = texturebuffer(arg4, $00)
    local13 = texturewidth(arg4)
    local14 = textureheight(arg4)
    lockbuffer(local11)
    lockbuffer(local12)
    For local2 = $00 To local0 Step $01
        For local3 = $00 To local1 Step $01
            local15 = min((((Float local2) * (Float local13)) / (Float local7)), (Float (local13 - $01)))
            local16 = ((Float local14) - min((((Float local3) * (Float local14)) / (Float (local1 + $01))), (Float (local14 - $01))))
            local17 = readpixelfast((Int min((Float local2), (Float (local0 - $01)))), (Int ((Float local1) - min((Float local3), (Float (local1 - $01))))), local11)
            local18 = ((local17 And $FF0000) Shr $10)
            local19 = (Float (((readpixelfast((Int max((local15 - 5.0), 5.0)), (Int max((local16 - 5.0), 5.0)), local12) And $FF000000) Shr $18) / $FF))
            local19 = ((Float (((readpixelfast((Int min((local15 + 5.0), ((Float local13) - 5.0))), (Int min((local16 + 5.0), (Float (local14 - $05)))), local12) And $FF000000) Shr $18) / $FF)) + local19)
            local19 = ((Float (((readpixelfast((Int max((local15 - 5.0), 5.0)), (Int min((local16 + 5.0), ((Float local14) - 5.0))), local12) And $FF000000) Shr $18) / $FF)) + local19)
            local19 = ((Float (((readpixelfast((Int min((local15 + 5.0), ((Float local13) - 5.0))), (Int max((local16 - 5.0), 5.0)), local12) And $FF000000) Shr $18) / $FF)) + local19)
            local19 = (local19 * 0.25)
            local19 = sqr(local19)
            local4 = ((local7 * local3) + local2)
            vertexcoords(local6, local4, vertexx(local6, local4), ((Float local18) * arg1), vertexz(local6, local4))
            vertexcoords(local10, local4, vertexx(local10, local4), ((Float local18) * arg1), vertexz(local10, local4))
            vertexcolor(local10, local4, 255.0, 255.0, 255.0, local19)
            vertextexcoords(local6, local4, (Float local2), (Float (- local3)), 1.0, $00)
            vertextexcoords(local10, local4, (Float local2), (Float (- local3)), 1.0, $00)
        Next
    Next
    unlockbuffer(local12)
    unlockbuffer(local11)
    updatenormals(local5)
    updatenormals(local9)
    entitytexture(local5, arg2, $00, $01)
    entitytexture(local9, arg3, $00, $01)
    entityfx(local5, $01)
    entityfx(local9, $23)
    Return local5
    Return $00
End Function
