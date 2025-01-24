Function createparticle.particles(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#, arg6#)
    Local local0.particles
    catcherrors((((((((((((((("CreateParticle(" + (Str arg0)) + ", ") + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ", ") + (Str arg4)) + ", ") + (Str arg5)) + ", ") + (Str arg6)) + ")"))
    local0 = (New particles)
    local0\Field0 = createsprite($00)
    positionentity(local0\Field0, arg1, arg2, arg3, $01)
    If (arg0 = $01) Then
        entitytexture(local0\Field0, p_i\Field0[arg0], rand($00, $03), $00)
    Else
        entitytexture(local0\Field0, p_i\Field0[arg0], $00, $00)
    EndIf
    rotateentity(local0\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
    spriteviewmode(local0\Field0, $03)
    Select arg0
        Case $00,$01,$03,$06
            entityfx(local0\Field0, $01)
            entityblend(local0\Field0, $01)
        Case $02,$04,$05,$07
            entityfx(local0\Field0, $09)
            entityblend(local0\Field0, $03)
    End Select
    local0\Field1 = createpivot($00)
    positionentity(local0\Field1, arg1, arg2, arg3, $01)
    local0\Field12 = arg6
    local0\Field6 = (arg5 * 0.004)
    local0\Field2 = 1.0
    local0\Field3 = arg4
    scalesprite(local0\Field0, local0\Field3, local0\Field3)
    If (p_i\Field0[arg0] = $00) Then
        runtimeerrorex(format(getlocalstring("runerr", "particle"), (Str arg0), "%s"))
    EndIf
    catcherrors((((((((((((((("Uncaught: CreateParticle(" + (Str arg0)) + ", ") + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ", ") + (Str arg4)) + ", ") + (Str arg5)) + ", ") + (Str arg6)) + ")"))
    Return local0
    Return Null
End Function
