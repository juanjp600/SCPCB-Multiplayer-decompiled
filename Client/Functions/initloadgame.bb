Function initloadgame%()
    Local local0.doors
    Local local1.securitycams
    Local local2.roomtemplates
    Local local3.events
    Local local4.props
    Local local5%
    Local local6#
    Local local7#
    Local local8#
    Local local9%
    Local local10.tempscreens
    Local local11.tempwaypoints
    Local local12.templights
    Local local13.tempprops
    Local local14.tempsoundemitters
    Local local15.chunk
    catcherrors("InitLoadGame()")
    initotherstuff()
    loadwaypoints($37)
    For local0 = Each doors
        entityparent(local0\Field0, $00, $01)
        If (local0\Field1 <> $00) Then
            entityparent(local0\Field1, $00, $01)
        EndIf
        If (local0\Field2 <> $00) Then
            entityparent(local0\Field2, $00, $01)
        EndIf
        For local5 = $00 To $01 Step $01
            If (local0\Field3[local5] <> $00) Then
                entityparent(local0\Field3[local5], $00, $01)
            EndIf
            If (local0\Field24[local5] <> $00) Then
                entityparent(local0\Field24[local5], $00, $01)
            EndIf
        Next
    Next
    For local1 = Each securitycams
        entityparent(local1\Field0, $00, $01)
        If (local1\Field2 <> $00) Then
            entityparent(local1\Field2, $00, $01)
        EndIf
    Next
    For local4 = Each props
        If (local4\Field3 <> "") Then
            local9 = loadtexture_strict(local4\Field3, $01, $00, $01)
            entitytexture(local4\Field1, local9, $00, $00)
            deletesingletextureentryfromcache(local9, $00)
            local9 = $00
            local4\Field3 = ""
        EndIf
    Next
    For local2 = Each roomtemplates
        freeentity(local2\Field0)
        local2\Field0 = $00
    Next
    For local10 = Each tempscreens
        Delete local10
    Next
    For local11 = Each tempwaypoints
        Delete local11
    Next
    For local12 = Each templights
        Delete local12
    Next
    For local13 = Each tempprops
        Delete local13
    Next
    For local14 = Each tempsoundemitters
        Delete local14
    Next
    renderloading($55, getlocalstring("loading", "events"))
    For local3 = Each events
        If (local3\Field0 = $49) Then
            If (2.0 = local3\Field2) Then
                local3\Field1\Field11[$00] = loadmesh_strict("GFX\Map\dimension1499\1499plane.b3d", $00)
                hideentity(local3\Field1\Field11[$00])
                local3\Field1\Field12[$00] = $01
                i_1499\Field8 = createsky("GFX\Map\sky\1499sky", $00)
                For local5 = $01 To $0F Step $01
                    local3\Field1\Field11[local5] = loadrmesh((("GFX\Map\dimension1499\dimension_1499_object(" + (Str local5)) + ").rmesh"), Null, $00)
                    scaleentity(local3\Field1\Field11[local5], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                    hideentity(local3\Field1\Field11[local5])
                Next
                createchunkparts(local3\Field1)
                local6 = entityx(local3\Field1\Field2, $00)
                local7 = entityy(local3\Field1\Field2, $00)
                local8 = entityz(local3\Field1\Field2, $00)
                For local5 = $FFFFFFFE To $00 Step $02
                    local15 = createchunk($FFFFFFFF, (((Float local5) * 2.5) * local6), local7, local8, $01)
                    local15 = createchunk($FFFFFFFF, (((Float local5) * 2.5) * local6), local7, (local8 - 40.0), $01)
                Next
            EndIf
            Exit
        EndIf
    Next
    renderloading($5A, getlocalstring("loading", "pos"))
    resetentity(me\Field60)
    movemouse(mo\Field9, mo\Field10)
    setfontex(fo\Field0[$00])
    hidepointer()
    me\Field36 = 0.0
    resetrender()
    updatenpcs()
    updateworld(1.0)
    deletetextureentriesfromcache($00)
    renderloading($64, "")
    fps\Field7[$00] = 0.0
    fps\Field1 = millisecs()
    resetinput()
    ue_server\Field11 = $01
    catcherrors("Uncaught: InitLoadGame()")
    Return $00
End Function
