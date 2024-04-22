Function multiplayer_updateplayermodel%(arg0%)
    Local local0.breachtypes
    Local local1%
    Local local2#
    Local local3%
    Local local4.breachtypes
    local0 = getbreachtype(player[arg0]\Field51)
    If (player[arg0]\Field12 <> $00) Then
        freeentity(player[arg0]\Field12)
        player[arg0]\Field12 = $00
    EndIf
    If (player[arg0]\Field40 = $00) Then
        player[arg0]\Field12 = copyentity(local0\Field2, $00)
        If (local0\Field4 <> "") Then
            local1 = loadtexture_strict(local0\Field4, $01)
            entitytexture(player[arg0]\Field12, local1, $00, $00)
            freetexture(local1)
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
        local2 = 0.013
        scaleentity(player[arg0]\Field12, local2, local2, local2, $00)
        meshcullbox(player[arg0]\Field12, (- meshwidth(classdobj)), (- meshheight(classdobj)), (- meshdepth(classdobj)), (meshwidth(classdobj) * 2.0), (meshheight(classdobj) * 2.0), (meshdepth(classdobj) * 2.0))
        local3 = loadtexture_strict("GFX\items\hazmat.jpg", $01)
        entitytexture(player[arg0]\Field12, local3, $00, $00)
        freetexture(local3)
        local4 = getbreachtype(classd_model)
        player[arg0]\Field15 = findchild(player[arg0]\Field12, local4\Field24[$01])
        player[arg0]\Field16 = findchild(player[arg0]\Field12, local4\Field24[$02])
        player[arg0]\Field17 = findchild(player[arg0]\Field12, local4\Field24[$03])
        player[arg0]\Field23 = findchild(player[arg0]\Field12, local4\Field24[$04])
        player[arg0]\Field18 = findchild(player[arg0]\Field12, local4\Field24[$05])
    EndIf
    Return $00
End Function
