Function initaafont%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    If (aatextenable <> 0) Then
        local0 = createcamera($00)
        cameraviewport(local0, $00, $00, $0A, $0A)
        camerazoom(local0, 0.1)
        cameraclsmode(local0, $00, $00)
        camerarange(local0, 0.1, 1.5)
        moveentity(local0, 0.0, 0.0, -20000.0)
        aatextcam = local0
        cameraprojmode(local0, $00)
        local1 = createmesh(local0)
        local2 = createsurface(local1, $00)
        addvertex(local2, -1.0, 1.0, 0.0, 0.0, 0.0, 1.0)
        addvertex(local2, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0)
        addvertex(local2, -1.0, -1.0, 0.0, 0.0, 1.0, 1.0)
        addvertex(local2, 1.0, -1.0, 0.0, 1.0, 1.0, 1.0)
        addtriangle(local2, $00, $01, $02)
        addtriangle(local2, $03, $02, $01)
        entityfx(local1, $31)
        positionentity(local1, 0.0, 0.0, 1.0001, $00)
        entityorder(local1, $FFFE795F)
        entityblend(local1, $01)
        aatextsprite[$00] = local1
        hideentity(aatextsprite[$00])
        For local3 = $01 To $FF Step $01
            local1 = copymesh(aatextsprite[$00], local0)
            entityfx(local1, $31)
            positionentity(local1, 0.0, 0.0, 1.0001, $00)
            entityorder(local1, $FFFE795F)
            entityblend(local1, $01)
            aatextsprite[local3] = local1
            hideentity(aatextsprite[local3])
        Next
    EndIf
    Return $00
End Function
