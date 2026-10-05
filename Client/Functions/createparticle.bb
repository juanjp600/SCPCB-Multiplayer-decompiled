Function createparticle.particles(arg0#, arg1#, arg2#, arg3%, arg4#, arg5#, arg6%, arg7#, arg8%)
    Local local0.particles
    local0 = (New particles)
    If (arg8 <> 0) Then
        If ((((hidedistance * 1.3) < distance2d(arg0, arg2, entityx(collider, $01), entityz(collider, $01))) Or removeparticles) <> 0) Then
            local0\Field15 = $01
        EndIf
    EndIf
    local0\Field14 = (Float arg6)
    local0\Field0 = createsprite($00)
    positionentity(local0\Field0, arg0, arg1, arg2, $01)
    entitytexture(local0\Field0, particletextures[arg3], $00, $00)
    rotatesprite(local0\Field0, (Float rand($168, $01)))
    Select arg3
        Case $04
            entityfx(local0\Field0, $09)
            entityblend(local0\Field0, $03)
        Case $02,$09
            entityfx(local0\Field0, $09)
            entityblend(local0\Field0, $01)
        Default
            entityblend(local0\Field0, $01)
            entityfx(local0\Field0, $08)
    End Select
    local0\Field1 = createpivot($00)
    positionentity(local0\Field1, arg0, arg1, arg2, $01)
    local0\Field2 = arg3
    local0\Field8 = (arg5 * 0.004)
    local0\Field3 = 0.8
    local0\Field4 = arg4
    scalesprite(local0\Field0, local0\Field4, local0\Field4)
    entityalpha(local0\Field0, arg7)
    Return local0
    Return Null
End Function
