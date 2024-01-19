Function multiplayer_createplayerobject%(arg0%)
    Local local0.breachtypes
    Local local1%
    Local local2%
    Local local3#
    Local local4%
    Local local5.breachtypes
    local0 = getbreachtype(player[arg0]\Field51)
    For local1 = $00 To $07 Step $01
        player[arg0]\Field80[local1] = $00
    Next
    If (player[arg0]\Field12 <> $00) Then
        freeentity(player[arg0]\Field12)
        player[arg0]\Field12 = $00
    EndIf
    freeplayerobjects(player[arg0])
    If (player[arg0]\Field40 = $00) Then
        player[arg0]\Field12 = copyentity(local0\Field2, $00)
        If (local0\Field4 <> "") Then
            local2 = loadtexture_strict(local0\Field4, $01)
            entitytexture(player[arg0]\Field12, local2, $00, $00)
            freetexture(local2)
        EndIf
        scaleentity(player[arg0]\Field12, local0\Field3, local0\Field3, local0\Field3, $00)
        meshcullbox(player[arg0]\Field12, ((- meshwidth(player[arg0]\Field12)) * 2.0), ((- meshheight(player[arg0]\Field12)) * 2.0), ((- meshdepth(player[arg0]\Field12)) * 2.0), (meshwidth(player[arg0]\Field12) * 2.0), (meshheight(player[arg0]\Field12) * 4.0), (meshdepth(player[arg0]\Field12) * 4.0))
        player[arg0]\Field15 = findchild(player[arg0]\Field12, local0\Field24[$01])
        player[arg0]\Field16 = findchild(player[arg0]\Field12, local0\Field24[$02])
        player[arg0]\Field17 = findchild(player[arg0]\Field12, local0\Field24[$03])
        player[arg0]\Field23 = findchild(player[arg0]\Field12, local0\Field24[$04])
        player[arg0]\Field18 = findchild(player[arg0]\Field12, local0\Field24[$05])
    Else
        player[arg0]\Field12 = copyentity(hazmat_object, $00)
        local3 = 0.013
        scaleentity(player[arg0]\Field12, local3, local3, local3, $00)
        meshcullbox(player[arg0]\Field12, (- meshwidth(classdobj)), (- meshheight(classdobj)), (- meshdepth(classdobj)), (meshwidth(classdobj) * 2.0), (meshheight(classdobj) * 2.0), (meshdepth(classdobj) * 2.0))
        local4 = loadtexture_strict("GFX\items\hazmat.jpg", $01)
        entitytexture(player[arg0]\Field12, local4, $00, $00)
        freetexture(local4)
        local5 = getbreachtype(classd_model)
        player[arg0]\Field15 = findchild(player[arg0]\Field12, local5\Field24[$01])
        player[arg0]\Field16 = findchild(player[arg0]\Field12, local5\Field24[$02])
        player[arg0]\Field17 = findchild(player[arg0]\Field12, local5\Field24[$03])
        player[arg0]\Field23 = findchild(player[arg0]\Field12, local5\Field24[$04])
        player[arg0]\Field18 = findchild(player[arg0]\Field12, local5\Field24[$05])
    EndIf
    If (getplayerhead(arg0) <> $00) Then
        player[arg0]\Field20 = entityroll(getplayerhead(arg0), $01)
    EndIf
    If (((player[arg0]\Field51 = classd_model) And (player[arg0]\Field40 = $00)) <> 0) Then
        If (player[arg0]\Field50 > $00) Then
            local4 = loadtexture_strict((("GFX\npcs\classd" + (Str player[arg0]\Field50)) + ".jpg"), $01)
            entitytexture(player[arg0]\Field12, local4, $00, $00)
            freetexture(local4)
        EndIf
    EndIf
    player[arg0]\Field14 = createcamera($00)
    If (player[arg0]\Field75 <> $00) Then
        cameraviewport(player[arg0]\Field14, $00, $00, player[arg0]\Field75, player[arg0]\Field76)
    Else
        cameraviewport(player[arg0]\Field14, $00, $00, graphicwidth, graphicheight)
    EndIf
    camerarange(player[arg0]\Field14, 0.05, 35.0)
    cameraprojmode(player[arg0]\Field14, $00)
    If (player[arg0]\Field13 = $00) Then
        player[arg0]\Field13 = createpivot($00)
        entitytype(player[arg0]\Field13, $02, $00)
        entityradius(player[arg0]\Field13, 0.15, 1.0)
        player[arg0]\Field19 = createcube($00)
        entityparent(player[arg0]\Field19, player[arg0]\Field13, $01)
        entitypickmode(player[arg0]\Field19, $02, $00)
        moveentity(player[arg0]\Field19, 0.0, -0.2, 0.0)
        entityalpha(player[arg0]\Field19, 0.0)
    EndIf
    scaleentity(player[arg0]\Field19, local0\Field10, local0\Field11, local0\Field12, $00)
    initplayerobjects(arg0)
    multiplayer_resetplayersize(arg0)
    Return $00
End Function
