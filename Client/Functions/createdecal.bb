Function createdecal.decals(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#, arg6#, arg7#, arg8#, arg9%, arg10%, arg11%, arg12%, arg13%)
    Local local0.decals
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    local0 = (New decals)
    local0\Field2 = arg0
    local0\Field3 = arg7
    local0\Field6 = arg8
    local0\Field9 = arg9
    local0\Field8 = arg10
    local0\Field10 = arg11
    local0\Field11 = arg12
    local0\Field12 = arg13
    local0\Field5 = 1.0
    local0\Field0 = createmesh($00)
    local0\Field1 = createsurface(local0\Field0, $00)
    local1 = addvertex(local0\Field1, -1.0, 1.0, 0.0, 0.0, 0.0, 1.0)
    local2 = addvertex(local0\Field1, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0)
    local3 = addvertex(local0\Field1, 1.0, -1.0, 0.0, 1.0, 1.0, 1.0)
    local4 = addvertex(local0\Field1, -1.0, -1.0, 0.0, 0.0, 1.0, 1.0)
    addtriangle(local0\Field1, local1, local2, local3)
    addtriangle(local0\Field1, local1, local3, local4)
    positionentity(local0\Field0, arg1, arg2, arg3, $01)
    scaleentity(local0\Field0, arg7, arg7, 1.0, $01)
    rotateentity(local0\Field0, arg4, arg5, arg6, $01)
    entitytexture(local0\Field0, de_i\Field0[arg0], $00, $00)
    entityalpha(local0\Field0, arg8)
    entityfx(local0\Field0, arg9)
    entityblend(local0\Field0, arg10)
    If ((((arg11 <> $00) Lor (arg12 <> $00)) Lor (arg13 <> $00)) <> 0) Then
        entitycolor(local0\Field0, (Float arg11), (Float arg12), (Float arg13))
    EndIf
    updatenormals(local0\Field0)
    hideentity(local0\Field0)
    If (de_i\Field0[arg0] = $00) Then
        runtimeerrorex(format(getlocalstring("runerr", "decals"), (Str arg0), "%s"))
    EndIf
    Return local0
    Return Null
End Function
