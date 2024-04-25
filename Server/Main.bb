; scpcbmp_server_2024_4_25_disasm
; Decompiled on 4/25/2024 10:28:01 PM

Include "Globals.bb"

Include "Functions/EntryPoint.bb"
Include "Functions/se_defineconst.bb"
Include "Functions/version.bb"
Include "Functions/addversion.bb"
Include "Functions/millisecs.bb"
Include "Functions/isanewyear.bb"
Include "Functions/isahalloween.bb"
Include "Functions/tcp_init.bb"
Include "Functions/initsteaminstances.bb"
Include "Functions/server_init.bb"
Include "Functions/loadsound_strict.bb"
Include "Functions/loadroomtemplates.bb"
Include "Functions/loadimage_strict.bb"
Include "Functions/settickrate.bb"
Include "Functions/server_start.bb"
Include "Functions/se_checkconstant.bb"
Include "Functions/createsteaminstance.bb"
Include "Functions/rcon_addcommand.bb"
Include "Functions/initserver.bb"
Include "Functions/createbytestream.bb"
Include "Functions/addlog.bb"
Include "Functions/preparemodels.bb"
Include "Functions/getinistring.bb"
Include "Functions/createroomtemplate.bb"
Include "Functions/getiniint.bb"
Include "Functions/strippath.bb"
Include "Functions/getscripts.bb"
Include "Functions/public_inqueue.bb"
Include "Functions/se_getreturnvalue.bb"
Include "Functions/nullmap.bb"
Include "Functions/initnewgame.bb"
Include "Functions/public_addparam.bb"
Include "Functions/callback.bb"
Include "Functions/requestdatafromglobal.bb"
Include "Functions/reloadudpstream.bb"
Include "Functions/setudpstreambuffersize.bb"
Include "Functions/udpreceive.bb"
Include "Functions/updatemap.bb"
Include "Functions/updateserver.bb"
Include "Functions/restartserver.bb"
Include "Functions/onserverstart.bb"
Include "Functions/addtexttochat.bb"
Include "Functions/createfile.bb"
Include "Functions/preparemodelidentifier.bb"
Include "Functions/debuglog.bb"
Include "Functions/updateinifile.bb"
Include "Functions/readiniline.bb"
Include "Functions/sound_onkill.bb"
Include "Functions/freeparticles.bb"
Include "Functions/cleartexturecache.bb"
Include "Functions/deletechunks.bb"
Include "Functions/deletedevilemitters.bb"
Include "Functions/freesound_strict.bb"
Include "Functions/loadnecessaryentities.bb"
Include "Functions/loadentities.bb"
Include "Functions/loadallsounds.bb"
Include "Functions/createplayer.bb"
Include "Functions/mp_createplayerobject.bb"
Include "Functions/generateseednumber.bb"
Include "Functions/loadmap.bb"
Include "Functions/createmap.bb"
Include "Functions/initevents.bb"
Include "Functions/initwaypoints.bb"
Include "Functions/createdecal.bb"
Include "Functions/createnpc.bb"
Include "Functions/countroomtriggerbox.bb"
Include "Functions/freetexturecache.bb"
Include "Functions/public_update_current.bb"
Include "Functions/public_clear.bb"
Include "Functions/downloadfile.bb"
Include "Functions/addcentralserver.bb"
Include "Functions/acceptpacket.bb"
Include "Functions/millisecs2.bb"
Include "Functions/setcurrtime.bb"
Include "Functions/getcurrtime.bb"
Include "Functions/getprevtime.bb"
Include "Functions/addtotimingaccumulator.bb"
Include "Functions/setprevtime.bb"
Include "Functions/gettickduration.bb"
Include "Functions/updateservermain.bb"
Include "Functions/microsecs.bb"
Include "Functions/updatesteamauthconnections.bb"
Include "Functions/mp_updateplayers.bb"
Include "Functions/updatetimers.bb"
Include "Functions/updateplayerscount.bb"
Include "Functions/updatechat.bb"
Include "Functions/breach_update.bb"
Include "Functions/kick_updater.bb"
Include "Functions/updatefakeplayers.bb"
Include "Functions/updatequerys.bb"
Include "Functions/istimedout.bb"
Include "Functions/server_network_update.bb"
Include "Functions/chat_network_update.bb"
Include "Functions/objects_network_update.bb"
Include "Functions/draws_network_update.bb"
Include "Functions/texts_network_update.bb"
Include "Functions/reverseto.bb"
Include "Functions/misc_network_update.bb"
Include "Functions/udp_writebyte.bb"
Include "Functions/udp_sendmessage.bb"
Include "Functions/errorlogex.bb"
Include "Functions/disconnectfromcentralserver.bb"
Include "Functions/setrandomseed.bb"
Include "Functions/kick.bb"
Include "Functions/reloadapplication.bb"
Include "Functions/mp_updateplayerposition.bb"
Include "Functions/mp_setroomnametoplayer.bb"
Include "Functions/removeauthconnection.bb"
Include "Functions/cfg_findcmd.bb"
Include "Functions/initvariables.bb"
Include "Functions/getformattedtext.bb"
Include "Functions/bool.bb"
Include "Functions/converttime.bb"
Include "Functions/callbacksingle.bb"
Include "Functions/rcon_loadbanlist.bb"
Include "Functions/rcon_loadsteambanlist.bb"
Include "Functions/stopstream_strict.bb"
Include "Functions/freetemplate.bb"
Include "Functions/freeemitter.bb"
Include "Functions/loadanimmesh_strict.bb"
Include "Functions/loadmesh_strict.bb"
Include "Functions/multiplayer_breach_createplayerrole.bb"
Include "Functions/multiplayer_breach_markroleasscp.bb"
Include "Functions/multiplayer_breach_setrolesettings.bb"
Include "Functions/multiplayer_breach_setroleeffects.bb"
Include "Functions/multiplayer_breach_setroleambientsound.bb"
Include "Functions/multiplayer_breach_setrolehitboxscales.bb"
Include "Functions/multiplayer_breach_setroleinstruction.bb"
Include "Functions/multiplayer_breach_setroleanimation.bb"
Include "Functions/multiplayer_breach_setrolearmedanimation.bb"
Include "Functions/multiplayer_breach_setroledeadanimation.bb"
Include "Functions/multiplayer_breach_setrolepositionsoffset.bb"
Include "Functions/multiplayer_breach_setrolebone.bb"
Include "Functions/multiplayer_breach_setroleholdinggrenade.bb"
Include "Functions/multiplayer_breach_setroleholdingitem.bb"
Include "Functions/multiplayer_breach_setrolehandcuff.bb"
Include "Functions/multiplayer_breach_allowroleweaponattaches.bb"
Include "Functions/multiplayer_breach_allowitemsattaches.bb"
Include "Functions/multiplayer_breach_markasfriend.bb"
Include "Functions/multiplayer_breach_allowrolegenerate.bb"
Include "Functions/multiplayer_breach_setmaxrolecount.bb"
Include "Functions/multiplayer_breach_setrolecategory.bb"
Include "Functions/getinifloat.bb"
Include "Functions/multiplayer_breach_setrolespeedmult.bb"
Include "Functions/multiplayer_breach_setrolehealth.bb"
Include "Functions/multiplayer_breach_setroleitem.bb"
Include "Functions/getgunname.bb"
Include "Functions/loadtexture_strict.bb"
Include "Functions/inititemtemplates.bb"
Include "Functions/setchunkdatavalues.bb"
Include "Functions/loadmaterials.bb"
Include "Functions/loadrmesh.bb"
Include "Functions/initparticles.bb"
Include "Functions/createtemplate.bb"
Include "Functions/settemplateemitterblend.bb"
Include "Functions/settemplateinterval.bb"
Include "Functions/settemplateparticlesperinterval.bb"
Include "Functions/settemplateemitterlifetime.bb"
Include "Functions/settemplateparticlelifetime.bb"
Include "Functions/settemplatetexture.bb"
Include "Functions/settemplateoffset.bb"
Include "Functions/settemplatevelocity.bb"
Include "Functions/settemplatealigntofall.bb"
Include "Functions/settemplategravity.bb"
Include "Functions/settemplatealphavel.bb"
Include "Functions/settemplatesize.bb"
Include "Functions/settemplatecolors.bb"
Include "Functions/settemplatefloor.bb"
Include "Functions/settemplatesizevel.bb"
Include "Functions/settemplatesubtemplate.bb"
Include "Functions/getbreachtype.bb"
Include "Functions/resetplayersize.bb"
Include "Functions/createroom.bb"
Include "Functions/wrapangle.bb"
Include "Functions/seteventvar.bb"
Include "Functions/findeventconst.bb"
Include "Functions/placeforest_mapcreator.bb"
Include "Functions/createdoor.bb"
Include "Functions/createevent.bb"
Include "Functions/getzone.bb"
Include "Functions/setroom.bb"
Include "Functions/preventroomoverlap.bb"
Include "Functions/createwaypoint.bb"
Include "Functions/createline.bb"
Include "Functions/nameentityex.bb"
Include "Functions/setnpcframe.bb"
Include "Functions/findfreenpcid.bb"
Include "Functions/npcspeedchange.bb"
Include "Functions/entityscalex.bb"
Include "Functions/entityscaley.bb"
Include "Functions/entityscalez.bb"
Include "Functions/getmeshextents.bb"
Include "Functions/public_getname.bb"
Include "Functions/public_update_lua.bb"
Include "Functions/se_addstringarg.bb"
Include "Functions/se_addintarg.bb"
Include "Functions/se_addfloatarg.bb"
Include "Functions/se_invokeuserfunction.bb"
Include "Functions/isvalidplayer.bb"
Include "Functions/setplayertype.bb"
Include "Functions/giveplayerhealth.bb"
Include "Functions/udp_writeline.bb"
Include "Functions/udp_writeint.bb"
Include "Functions/udp_writebytes.bb"
Include "Functions/udp_writefloat.bb"
Include "Functions/playsound_strict.bb"
Include "Functions/breach_isstarted.bb"
Include "Functions/readlinesafe.bb"
Include "Functions/isaccessversion.bb"
Include "Functions/sendserverdatatoplayer.bb"
Include "Functions/findfreeplayerid.bb"
Include "Functions/getnamedifficulty.bb"
Include "Functions/clearchatforplayer.bb"
Include "Functions/sendfile.bb"
Include "Functions/convertshorttovalue.bb"
Include "Functions/readbool.bb"
Include "Functions/mp_isascp.bb"
Include "Functions/readignorebytes.bb"
Include "Functions/getbytestreamdata.bb"
Include "Functions/acceptmicrobytepacket.bb"
Include "Functions/updaterooms.bb"
Include "Functions/updatenpcs.bb"
Include "Functions/updateemitters.bb"
Include "Functions/updatedoors.bb"
Include "Functions/updateparticles.bb"
Include "Functions/updatedevilemitters.bb"
Include "Functions/updateparticles_devil.bb"
Include "Functions/updatedecals.bb"
Include "Functions/updatemtf.bb"
Include "Functions/updaterockets.bb"
Include "Functions/updatesecuritycams.bb"
Include "Functions/updateitems.bb"
Include "Functions/updatedeadbodies.bb"
Include "Functions/quickloadevents.bb"
Include "Functions/updateevents.bb"
Include "Functions/updatedimension1499.bb"
Include "Functions/mp_getplayer.bb"
Include "Functions/mp_updateplayerrole.bb"
Include "Functions/bytestreamreadint.bb"
Include "Functions/bytestreamreadfloat.bb"
Include "Functions/bytestreamreadstring.bb"
Include "Functions/public_update_by_func.bb"
Include "Functions/bytestreamresetread.bb"
Include "Functions/removetimer.bb"
Include "Functions/checkplayertimeout.bb"
Include "Functions/mp_isafriend.bb"
Include "Functions/mp_sendblinktimer.bb"
Include "Functions/shuffleplayersarray.bb"
Include "Functions/randombetween.bb"
Include "Functions/breach_countroles.bb"
Include "Functions/breach_getrolecount.bb"
Include "Functions/breach_getcategorybytype.bb"
Include "Functions/breach_getcategorycount.bb"
Include "Functions/removeitem.bb"
Include "Functions/breach_givetickets.bb"
Include "Functions/distance.bb"
Include "Functions/multiplayer_breach_isa035.bb"
Include "Functions/breach_checkmatchover.bb"
Include "Functions/spawnmtf.bb"
Include "Functions/deactivatewarheads.bb"
Include "Functions/activatewarheads.bb"
Include "Functions/getplayerzone.bb"
Include "Functions/startouttimer.bb"
Include "Functions/bytestreamreset.bb"
Include "Functions/bytestreamwritechar.bb"
Include "Functions/bytestreamwritefloat.bb"
Include "Functions/converttoshort.bb"
Include "Functions/bytestreamwriteshort.bb"
Include "Functions/udp_writeshort.bb"
Include "Functions/getbytestreamdatasize.bb"
Include "Functions/entityscalex2.bb"
Include "Functions/isablockedevent.bb"
Include "Functions/isablockedroom.bb"
Include "Functions/writenpcs.bb"
Include "Functions/writedoors.bb"
Include "Functions/writeitems.bb"
Include "Functions/writeasdata.bb"
Include "Functions/writeelevators.bb"
Include "Functions/writecorpses.bb"
Include "Functions/removebytestream.bb"
Include "Functions/getdiff.bb"
Include "Functions/cfg_findbool.bb"
Include "Functions/gettickratedelay.bb"
Include "Functions/se_executefunction.bb"
Include "Functions/piece.bb"
Include "Functions/se_isvalidscript.bb"
Include "Functions/skynet_onload.bb"
Include "Functions/countchar.bb"
Include "Functions/se_init.bb"
Include "Functions/se_loadscriptexec.bb"
Include "Functions/init_publics_for_script.bb"
Include "Functions/declaredefine.bb"
Include "Functions/se_compilescript.bb"
Include "Functions/se_clearcompiler.bb"
Include "Functions/limit.bb"
Include "Functions/limit2.bb"
Include "Functions/rcon_difficulty.bb"
Include "Functions/createitemtemplate.bb"
Include "Functions/stripfilename.bb"
Include "Functions/gettexturefromcache.bb"
Include "Functions/addtexturetocache.bb"
Include "Functions/addtemplight.bb"
Include "Functions/createpropobj.bb"
Include "Functions/settemplatemaxparticles.bb"
Include "Functions/settemplatealpha.bb"
Include "Functions/settemplatebrightness.bb"
Include "Functions/settemplatefixangles.bb"
Include "Functions/findfreeroomid.bb"
Include "Functions/loadroommesh.bb"
Include "Functions/loadroomprops.bb"
Include "Functions/fillroom.bb"
Include "Functions/calculateroomextents.bb"
Include "Functions/findfreeeventid.bb"
Include "Functions/seteventid.bb"
Include "Functions/load_terrain.bb"
Include "Functions/createitem.bb"
Include "Functions/findfreedoorid.bb"
Include "Functions/checkroomoverlap.bb"
Include "Functions/se_returnstring.bb"
Include "Functions/se_growarguments.bb"
Include "Functions/se_growtransient.bb"
Include "Functions/se_getfinalvalue.bb"
Include "Functions/se_gccheck.bb"
Include "Functions/se_getaccessorvalue.bb"
Include "Functions/se_invokeglobalfunction.bb"
Include "Functions/se_argstoarray.bb"
Include "Functions/se_array_create_inst.bb"
Include "Functions/se_array_getelement.bb"
Include "Functions/adderrorlog.bb"
Include "Functions/playerdead.bb"
Include "Functions/zipapi_compress.bb"
Include "Functions/onplayeruseitem.bb"
Include "Functions/sendplayermsg.bb"
Include "Functions/playerdropitem.bb"
Include "Functions/onplayerconsole.bb"
Include "Functions/mp_setplayerroomid.bb"
Include "Functions/multiplayer_breach_isa049.bb"
Include "Functions/distance3.bb"
Include "Functions/usedoor.bb"
Include "Functions/playsoundforplayer.bb"
Include "Functions/oncheatdetected.bb"
Include "Functions/readignoreline.bb"
Include "Functions/movetopocketdimension.bb"
Include "Functions/rcon_findcmd.bb"
Include "Functions/rcon_getattribute.bb"
Include "Functions/rcon_executecmd.bb"
Include "Functions/changeplayersize.bb"
Include "Functions/isagun.bb"
Include "Functions/getgundamage.bb"
Include "Functions/createrocket.bb"
Include "Functions/creategrenade.bb"
Include "Functions/isitemgoodfor1162.bb"
Include "Functions/multiplayer_updateplayerroom.bb"
Include "Functions/removenpc.bb"
Include "Functions/checkfornpcinfacility.bb"
Include "Functions/findnearestid.bb"
Include "Functions/loopsound2.bb"
Include "Functions/getcamera.bb"
Include "Functions/teleportcloser.bb"
Include "Functions/curvevalue.bb"
Include "Functions/loadtempsound.bb"
Include "Functions/createsound.bb"
Include "Functions/curveangle.bb"
Include "Functions/playerinroom.bb"
Include "Functions/playsound2.bb"
Include "Functions/animatenpc.bb"
Include "Functions/giveachievement.bb"
Include "Functions/findpath.bb"
Include "Functions/teleportentity.bb"
Include "Functions/updatesoundorigin.bb"
Include "Functions/streamsound_strict.bb"
Include "Functions/updatestreamsoundorigin.bb"
Include "Functions/setstreamvolume_strict.bb"
Include "Functions/otherplayerinreachableroom.bb"
Include "Functions/menpcseesplayer.bb"
Include "Functions/kill.bb"
Include "Functions/shoot.bb"
Include "Functions/createparticle.bb"
Include "Functions/updatemtfunit.bb"
Include "Functions/animate2.bb"
Include "Functions/getstepsound.bb"
Include "Functions/point_direction.bb"
Include "Functions/find860angle.bb"
Include "Functions/updatesoundorigin2.bb"
Include "Functions/checkformultiplayerinfacility.bb"
Include "Functions/playannouncement.bb"
Include "Functions/removeemitter.bb"
Include "Functions/removeparticle.bb"
Include "Functions/multiplayer_isafriend.bb"
Include "Functions/updategrenades.bb"
Include "Functions/changenpctextureid.bb"
Include "Functions/createchunkparts.bb"
Include "Functions/createchunk.bb"
Include "Functions/updatebreachevents.bb"
Include "Functions/findeventobject.bb"
Include "Functions/calculatedist.bb"
Include "Functions/getobject.bb"
Include "Functions/updateending.bb"
Include "Functions/updateelevators.bb"
Include "Functions/update096elevatorevent.bb"
Include "Functions/checktriggers.bb"
Include "Functions/removeevent.bb"
Include "Functions/setplayerposition.bb"
Include "Functions/createemitter.bb"
Include "Functions/removedoor.bb"
Include "Functions/loadeventsound.bb"
Include "Functions/turncheckpointmonitorsoff.bb"
Include "Functions/updatecheckpointmonitors.bb"
Include "Functions/angledist.bb"
Include "Functions/point_distance.bb"
Include "Functions/updatelever.bb"
Include "Functions/setplayerpositionex.bb"
Include "Functions/playmtfsound.bb"
Include "Functions/placegrid_mapcreator.bb"
Include "Functions/addlight.bb"
Include "Functions/isstreamplaying_strict.bb"
Include "Functions/updateforest.bb"
Include "Functions/hideforest.bb"
Include "Functions/use914.bb"
Include "Functions/updatebutton.bb"
Include "Functions/hidechunks.bb"
Include "Functions/updatechunks.bb"
Include "Functions/tracecamera.bb"
Include "Functions/mp_updateplayerstate.bb"
Include "Functions/updateplayersize.bb"
Include "Functions/bytestreamreadshort.bb"
Include "Functions/bytestreamreadchar.bb"
Include "Functions/getgunshootticks.bb"
Include "Functions/getgunspreadrate.bb"
Include "Functions/createbullet.bb"
Include "Functions/createrolecorpse.bb"
Include "Functions/giveitem.bb"
Include "Functions/playsoundforall.bb"
Include "Functions/breach_getcategorycolor.bb"
Include "Functions/breach_getcategoryname.bb"
Include "Functions/slua_load_functions.bb"
Include "Functions/se_and_lua_tointarg.bb"
Include "Functions/se_and_lua_tostringarg.bb"
Include "Functions/se_and_lua_tofloatarg.bb"
Include "Functions/gettypename.bb"
Include "Functions/multiplayer_breach_roletakerolespawn.bb"
Include "Functions/multiplayer_breach_markas035.bb"
Include "Functions/multiplayer_breach_markas049.bb"
Include "Functions/multiplayer_breach_getmaxhp.bb"
Include "Functions/multiplayer_breach_getrolescale.bb"
Include "Functions/se_getparamint.bb"
Include "Functions/getplayerdownloadingcount.bb"
Include "Functions/object_sound_create.bb"
Include "Functions/entityscaley2.bb"
Include "Functions/entityscalez2.bb"
Include "Functions/changeplayersteamid.bb"
Include "Functions/se_getparamstring.bb"
Include "Functions/connecttocentralserver.bb"
Include "Functions/opendatabase.bb"
Include "Functions/closedatabase.bb"
Include "Functions/setdatabasetimeout.bb"
Include "Functions/databaseversion.bb"
Include "Functions/lastrowidinserted.bb"
Include "Functions/rowschangedbylaststatement.bb"
Include "Functions/rowschangedthissession.bb"
Include "Functions/autocommitison.bb"
Include "Functions/begintransaction.bb"
Include "Functions/committransaction.bb"
Include "Functions/rollbacktransaction.bb"
Include "Functions/lastdatabaseerrorcode.bb"
Include "Functions/lastdatabaseerrormessage.bb"
Include "Functions/interruptdatabase.bb"
Include "Functions/executesql.bb"
Include "Functions/preparesql.bb"
Include "Functions/getnextdatarow.bb"
Include "Functions/finalisesql.bb"
Include "Functions/resetsql.bb"
Include "Functions/sqlhasexpired.bb"
Include "Functions/getdatabasehandlefromstatementhandle.bb"
Include "Functions/getcolumncount.bb"
Include "Functions/getcolumnname.bb"
Include "Functions/getcolumntype.bb"
Include "Functions/getcolumndeclaredtype.bb"
Include "Functions/getcolumnsize.bb"
Include "Functions/getcolumnvalueasinteger.bb"
Include "Functions/getcolumnvalueasfloat.bb"
Include "Functions/getcolumnvalueasstring.bb"
Include "Functions/getcolumnvalueasblob.bb"
Include "Functions/sqlparametercount.bb"
Include "Functions/sqlparametername.bb"
Include "Functions/sqlparameterindex.bb"
Include "Functions/bindsqlparameterasnull.bb"
Include "Functions/bindsqlparameterasinteger.bb"
Include "Functions/se_getparamfloat.bb"
Include "Functions/bindsqlparameterasfloat.bb"
Include "Functions/bindsqlparameterasstring.bb"
Include "Functions/bindsqlparameterasblob.bb"
Include "Functions/transfersqlbindings.bb"
Include "Functions/sqlite3_errorhasoccurred.bb"
Include "Functions/zipapi_uncompress.bb"
Include "Functions/rcon_password.bb"
Include "Functions/se_argtype.bb"
Include "Functions/bytestreamwriteint.bb"
Include "Functions/bytestreamwritestring.bb"
Include "Functions/settimer.bb"
Include "Functions/var_remove.bb"
Include "Functions/var_setvalue.bb"
Include "Functions/var_getvalue.bb"
Include "Functions/player_var_remove.bb"
Include "Functions/player_var_setvalue.bb"
Include "Functions/player_var_getvalue.bb"
Include "Functions/se_intarg.bb"
Include "Functions/se_arrayarg.bb"
Include "Functions/se_array_addelements.bb"
Include "Functions/objects_stream_update.bb"
Include "Functions/object_update_visible.bb"
Include "Functions/object_update_lerp.bb"
Include "Functions/se_findfunc.bb"
Include "Functions/createplayersound.bb"
Include "Functions/text_setpos.bb"
Include "Functions/text_settext.bb"
Include "Functions/text_setcolor.bb"
Include "Functions/draw_setcolor.bb"
Include "Functions/draw_setpos.bb"
Include "Functions/setplayerfogrange.bb"
Include "Functions/object_remove.bb"
Include "Functions/object_create.bb"
Include "Functions/text_remove.bb"
Include "Functions/text_create.bb"
Include "Functions/draw_remove.bb"
Include "Functions/draw_create.bb"
Include "Functions/shoot2.bb"
Include "Functions/sendconsolecommand.bb"
Include "Functions/playsoundforplayers.bb"
Include "Functions/rcon_banip.bb"
Include "Functions/plugin_remove.bb"
Include "Functions/plugin_call.bb"
Include "Functions/plugin_poke.bb"
Include "Functions/plugin_init.bb"
Include "Functions/putinivalue.bb"
Include "Functions/getunixtimestamp.bb"
Include "Functions/se_and_lua_returnint.bb"
Include "Functions/se_and_lua_returnfloat.bb"
Include "Functions/se_and_lua_returnstring.bb"
Include "Functions/se_bl_array_create.bb"
Include "Functions/se_bl_array_push.bb"
Include "Functions/se_bl_array_pop.bb"
Include "Functions/se_bl_array_delete.bb"
Include "Functions/se_bl_array_sort.bb"
Include "Functions/se_bl_array_fromstring.bb"
Include "Functions/changeplayernickname.bb"
Include "Functions/changeplayertag.bb"
Include "Functions/se_createinst.bb"
Include "Functions/se_createfuncptr.bb"
Include "Functions/se_createpublic.bb"
Include "Functions/se_readarg.bb"
Include "Functions/se_compile.bb"
Include "Functions/se_vf_savebin.bb"
Include "Functions/se_vf_closefile.bb"
Include "Functions/generateindex.bb"
Include "Functions/getcache.bb"
Include "Functions/loadworld.bb"
Include "Functions/calculateroomtemplateextents.bb"
Include "Functions/genforestgrid.bb"
Include "Functions/placeforest.bb"
Include "Functions/createsecuritycam.bb"
Include "Functions/placehalloweenscene.bb"
Include "Functions/createbutton.bb"
Include "Functions/createdevilemitter.bb"
Include "Functions/createscreen.bb"
Include "Functions/findfreeitemid.bb"
Include "Functions/setitemid.bb"
Include "Functions/se_array_create.bb"
Include "Functions/se_array_addelement.bb"
Include "Functions/isplayeradmin.bb"
Include "Functions/console_spawnnpc.bb"
Include "Functions/rcon_bansteamid.bb"
Include "Functions/rcon_kick.bb"
Include "Functions/mp_breach_getname.bb"
Include "Functions/rcon_reloadbanlist.bb"
Include "Functions/rcon_hostname.bb"
Include "Functions/rcon_restart.bb"
Include "Functions/rcon_gravity.bb"
Include "Functions/rcon_mapseed.bb"
Include "Functions/findplayer.bb"
Include "Functions/getplayerinjuries.bb"
Include "Functions/othernpcseesmenpc.bb"
Include "Functions/finishwalking.bb"
Include "Functions/flipangle.bb"
Include "Functions/bouncewall.bb"
Include "Functions/getinisectionlocation.bb"
Include "Functions/getinistring2.bb"
Include "Functions/mp_writedecal.bb"
Include "Functions/findfreecorpseid.bb"
Include "Functions/se_getfunctionid.bb"
Include "Functions/se_tointarg.bb"
Include "Functions/se_tostringarg.bb"
Include "Functions/se_tofloatarg.bb"
Include "Functions/getconnectiontocentralserver.bb"
Include "Functions/setcentralserver.bb"
Include "Functions/var_getid.bb"
Include "Functions/player_var_getid.bb"
Include "Functions/se_setvalue.bb"
Include "Functions/object_getid.bb"
Include "Functions/text_getid.bb"
Include "Functions/draw_getid.bb"
Include "Functions/plugin_clear.bb"
Include "Functions/peekstring_work.bb"
Include "Functions/ini_filetostring.bb"
Include "Functions/ini_createkey.bb"
Include "Functions/ini_createsection.bb"
Include "Functions/se_returnint.bb"
Include "Functions/se_returnfloat.bb"
Include "Functions/se_returnarray.bb"
Include "Functions/se_returnpointer.bb"
Include "Functions/se_array_freeelement.bb"
Include "Functions/se_parselines.bb"
Include "Functions/se_parsetokens.bb"
Include "Functions/se_parsechunks.bb"
Include "Functions/se_parseblocks.bb"
Include "Functions/se_parsedefinitions.bb"
Include "Functions/se_checksyntax.bb"
Include "Functions/se_compileblock.bb"
Include "Functions/se_vf_createinst.bb"
Include "Functions/se_indextemps.bb"
Include "Functions/keyvalue.bb"
Include "Functions/chance.bb"
Include "Functions/turn_if_deviating.bb"
Include "Functions/move_forward.bb"
Include "Functions/sqrvalue.bb"
Include "Functions/bcreatevector.bb"
Include "Functions/bbounce.bb"
Include "Functions/tcp_sendmsg.bb"
Include "Functions/iptodecimal.bb"
Include "Functions/se_warn.bb"
Include "Functions/se_parsedirective.bb"
Include "Functions/deletestringfromstring.bb"
Include "Functions/instrlatest.bb"
Include "Functions/se_pp_include.bb"
Include "Functions/se_seterror.bb"
Include "Functions/se_createtoken.bb"
Include "Functions/se_checkidentifier.bb"
Include "Functions/se_checkoperator.bb"
Include "Functions/se_parseexpression.bb"
Include "Functions/se_error_unexpected.bb"
Include "Functions/se_error.bb"
Include "Functions/se_parseblock.bb"
Include "Functions/se_definefunction.bb"
Include "Functions/se_parsedefinition.bb"
Include "Functions/se_checkfunction.bb"
Include "Functions/se_checkglobalscope.bb"
Include "Functions/se_blocksyntax.bb"
Include "Functions/se_compilenode.bb"
Include "Functions/se_poptemp.bb"
Include "Functions/se_compile_var.bb"
Include "Functions/se_compile_def.bb"
Include "Functions/se_compile_if.bb"
Include "Functions/se_compile_select.bb"
Include "Functions/se_compile_for.bb"
Include "Functions/se_compile_while.bb"
Include "Functions/se_compile_do.bb"
Include "Functions/se_compile_break.bb"
Include "Functions/se_compile_continue.bb"
Include "Functions/se_compile_return.bb"
Include "Functions/bproject.bb"
Include "Functions/bmult.bb"
Include "Functions/badd.bb"
Include "Functions/se_error_eol.bb"
Include "Functions/se_definenode.bb"
Include "Functions/se_linknode.bb"
Include "Functions/se_linkblock.bb"
Include "Functions/se_checkchunk.bb"
Include "Functions/se_error_expecting.bb"
Include "Functions/se_vf_createfuncptr.bb"
Include "Functions/se_definelocal.bb"
Include "Functions/se_definestatic.bb"
Include "Functions/se_defineglobal.bb"
Include "Functions/se_definepublic.bb"
Include "Functions/se_nodesyntax.bb"
Include "Functions/se_var_syntax.bb"
Include "Functions/se_def_syntax.bb"
Include "Functions/se_if_syntax.bb"
Include "Functions/se_else_syntax.bb"
Include "Functions/se_select_syntax.bb"
Include "Functions/se_case_syntax.bb"
Include "Functions/se_for_syntax.bb"
Include "Functions/se_while_syntax.bb"
Include "Functions/se_do_syntax.bb"
Include "Functions/se_repeat_syntax.bb"
Include "Functions/se_break_syntax.bb"
Include "Functions/se_continue_syntax.bb"
Include "Functions/se_return_syntax.bb"
Include "Functions/se_vf_createbasic.bb"
Include "Functions/se_compileidentifier.bb"
Include "Functions/se_compileoperator.bb"
Include "Functions/se_compileparenthesis.bb"
Include "Functions/se_compilearray.bb"
Include "Functions/se_nextnode.bb"
Include "Functions/se_getfunctiondef.bb"
Include "Functions/se_vf_createlabel.bb"
Include "Functions/se_getvariable.bb"
Include "Functions/se_vf_getlabel.bb"
Include "Functions/se_pushtemp.bb"
Include "Functions/se_pushblock.bb"
Include "Functions/se_popblock.bb"
Include "Functions/bdot.bb"
Include "Functions/bnorm.bb"
Include "Functions/bnormalize.bb"
Include "Functions/se_checklocalscope.bb"
Include "Functions/se_vf_createtransient.bb"
Include "Functions/se_vf_createstatic.bb"
Include "Functions/se_vf_createpublic.bb"
Include "Functions/se_operatorsyntax.bb"
Include "Functions/se_parenthesissyntax.bb"
Include "Functions/se_arraysyntax.bb"
Include "Functions/se_blockbodysyntax.bb"
Include "Functions/se_getconstant.bb"
Include "Functions/se_getfunction.bb"
Include "Functions/se_isvalidfunction.bb"

Include "Types/antiddos.bb"
Include "Types/authconnection.bb"
Include "Types/banned.bb"
Include "Types/breach.bb"
Include "Types/breachtypes.bb"
Include "Types/bs.bb"
Include "Types/bs_callbackmsg_t.bb"
Include "Types/bs_globalachievementpercentagesready_t.bb"
Include "Types/bs_globalstatsreceived_t.bb"
Include "Types/bs_isteamuserstatsreceived_t.bb"
Include "Types/bs_isteamuserstatsstored_t.bb"
Include "Types/bs_isteamuserstatsunloaded_t.bb"
Include "Types/bs_leaderboardentry_t.bb"
Include "Types/bs_leaderboardfindresult_t.bb"
Include "Types/bs_leaderboardscoresdownloaded_t.bb"
Include "Types/bs_leaderboardscoreuploaded_t.bb"
Include "Types/bs_leaderboardugcset_t.bb"
Include "Types/bs_numberofcurrentplayers_t.bb"
Include "Types/bs_p2psessionconnectfail_t.bb"
Include "Types/bs_p2psessionrequest_t.bb"
Include "Types/bs_p2psessionstate_t.bb"
Include "Types/bs_steaminventory_steamitemdetails.bb"
Include "Types/bs_userachievementiconfetched_t.bb"
Include "Types/bs_userachievementstored_t.bb"
Include "Types/bullets.bb"
Include "Types/bvector.bb"
Include "Types/centralserverdata.bb"
Include "Types/centralserversegments.bb"
Include "Types/chatmessage.bb"
Include "Types/chunk.bb"
Include "Types/chunkpart.bb"
Include "Types/corpses.bb"
Include "Types/databasehandlecontainer.bb"
Include "Types/decals.bb"
Include "Types/defines.bb"
Include "Types/devilemitters.bb"
Include "Types/difficulty.bb"
Include "Types/doors.bb"
Include "Types/draws.bb"
Include "Types/dummy1499.bb"
Include "Types/emitter.bb"
Include "Types/emitters.bb"
Include "Types/errs.bb"
Include "Types/eventq.bb"
Include "Types/events.bb"
Include "Types/e_bank.bb"
Include "Types/fasttcps.bb"
Include "Types/fixedtimesteps.bb"
Include "Types/forest.bb"
Include "Types/gl_.bb"
Include "Types/grenades.bb"
Include "Types/grids.bb"
Include "Types/g_i.bb"
Include "Types/inifile.bb"
Include "Types/items.bb"
Include "Types/itemtemplates.bb"
Include "Types/lighttemplates.bb"
Include "Types/mapzones.bb"
Include "Types/materials.bb"
Include "Types/mp_objects.bb"
Include "Types/multiplayerserver.bb"
Include "Types/npcs.bb"
Include "Types/particle.bb"
Include "Types/particles.bb"
Include "Types/pb.bb"
Include "Types/players.bb"
Include "Types/playervariables.bb"
Include "Types/plugin.bb"
Include "Types/props.bb"
Include "Types/querys.bb"
Include "Types/rcon.bb"
Include "Types/rockets.bb"
Include "Types/rooms.bb"
Include "Types/roomtemplates.bb"
Include "Types/screens.bb"
Include "Types/scriptsthread.bb"
Include "Types/securitycams.bb"
Include "Types/servervariables.bb"
Include "Types/se_array.bb"
Include "Types/se_block.bb"
Include "Types/se_blockspace.bb"
Include "Types/se_chunk.bb"
Include "Types/se_constantdef.bb"
Include "Types/se_funcptr.bb"
Include "Types/se_functiondef.bb"
Include "Types/se_globaldef.bb"
Include "Types/se_inst.bb"
Include "Types/se_instance.bb"
Include "Types/se_line.bb"
Include "Types/se_localdef.bb"
Include "Types/se_node.bb"
Include "Types/se_pptoken.bb"
Include "Types/se_public.bb"
Include "Types/se_publicdef.bb"
Include "Types/se_script.bb"
Include "Types/se_staticdef.bb"
Include "Types/se_tempvalue.bb"
Include "Types/se_token.bb"
Include "Types/se_value.bb"
Include "Types/se_vf_funcptr.bb"
Include "Types/se_vf_inst.bb"
Include "Types/se_vf_label.bb"
Include "Types/se_vf_public.bb"
Include "Types/se_vf_value.bb"
Include "Types/se_warning.bb"
Include "Types/sounds.bb"
Include "Types/spawnpoint.bb"
Include "Types/steaminstances.bb"
Include "Types/stream.bb"
Include "Types/template.bb"
Include "Types/tempscreens.bb"
Include "Types/tempwaypoints.bb"
Include "Types/texts.bb"
Include "Types/ticks.bb"
Include "Types/timers.bb"
Include "Types/types_ticks.bb"
Include "Types/versions.bb"
Include "Types/waypoints.bb"
Include "Types/zipapi_date.bb"
Include "Types/zipapi_globalinfo.bb"
Include "Types/zipapi_unzfileinfo.bb"

Dim achievementdescs$(0)
Dim achievementstrings$(0)
Dim achievements%(0)
Dim achvimg%(0)
Dim alarmsfx%(0)
Dim ambientsfxamount%(0)
Dim ambientsfx%(0, 0)
Dim bigdoorobj%(0)
Dim breathsfx%(0, 0)
Dim chunkdata%(0, 0)
Dim closedoorsfx%(0, 0)
Dim commotionstate%(0)
Dim coughsfx%(0)
Dim damagesfx%(0)
Dim decaltextures%(0)
Dim decaysfx%(0)
Dim difficulties.difficulty(0)
Dim dripsfx%(0)
Dim gorepics%(0)
Dim heavydoorobj%(0)
Dim horrorsfx%(0)
Dim introsfx%(0)
Dim lightspritetex%(0)
Dim mapfound%(0, 0)
Dim mapf%(0, 0)
Dim mapg%(0, 0)
Dim maph%(0, 0)
Dim mapname$(0, 0)
Dim mapparent%(0, 0, 0)
Dim maproomid%(0)
Dim maproom$(0, 0)
Dim mapstate%(0, 0)
Dim maptemp%(0, 0)
Dim mtfsfx%(0)
Dim necksnapsfx%(0)
Dim objtunnel%(0)
Dim oldaipics%(0)
Dim oldmansfx%(0)
Dim opendoorsfx%(0, 0)
Dim particletextures%(0)
Dim picksfx%(0)
Dim radiochn%(0)
Dim radiosfx%(0, 0)
Dim radiostate3%(0)
Dim radiostate4%(0)
Dim radiostate#(0)
Dim rustlesfx%(0)
Dim scp173sfx%(0)
Dim se_arguments_stack.se_value(0)
Dim se_aux_arguments_stack.se_value(0)
Dim se_aux_transient_stack.se_value(0)
Dim se_transient_stack.se_value(0)
Dim se_vf_a_func_ptr.se_funcptr(0)
Dim se_vf_a_inst.se_inst(0)
Dim se_vf_a_label.se_value(0)
Dim se_vf_a_static.se_value(0)
Dim step2sfx%(0)
Dim stepsfx%(0, 0, 0)

Const INFINITY# = (999.0) ^ (99999.0)
Const NAN# = (-1.0) ^ (0.5)

EntryPoint()
