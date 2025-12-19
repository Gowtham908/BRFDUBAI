package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRF_REF_CODE_TABLE")
public class BRF_REF_CODE_ENTITY {
	
	@Id
	private String	report_srl;
	private Date	report_version_date;
	private String	report_code;
	private String	report_desc;
	private String	report_category;
	private String	report_frequency;
	private Date	due_date;
	private String	row_101;
	private String	row_102;
	private String	row_103;
	private String	row_104;
	private String	row_105;
	private String	row_106;
	private String	row_107;
	private String	row_108;
	private String	row_109;
	private String	row_110;
	private String	row_111;
	private String	row_112;
	private String	row_113;
	private String	row_114;
	private String	row_115;
	private String	row_116;
	private String	row_117;
	private String	row_118;
	private String	row_119;
	private String	row_120;
	private String	row_121;
	private String	row_122;
	private String	row_123;
	private String	row_124;
	private String	row_125;
	private String	row_126;
	private String	row_127;
	private String	row_128;
	private String	row_129;
	private String	row_130;
	private String	row_131;
	private String	row_132;
	private String	row_133;
	private String	row_134;
	private String	row_135;
	private String	row_136;
	private String	row_137;
	private String	row_138;
	private String	row_139;
	private String	row_140;
	private String	row_141;
	private String	row_142;
	private String	row_143;
	private String	row_144;
	private String	row_145;
	private String	row_146;
	private String	row_147;
	private String	row_148;
	private String	row_149;
	private String	row_150;
	private String	row_151;
	private String	row_152;
	private String	row_153;
	private String	row_154;
	private String	row_155;
	private String	row_156;
	private String	row_157;
	private String	row_158;
	private String	row_159;
	private String	row_160;
	private String	row_161;
	private String	row_162;
	private String	row_163;
	private String	row_164;
	private String	row_165;
	private String	row_166;
	private String	row_167;
	private String	row_168;
	private String	row_169;
	private String	row_170;
	private String	row_171;
	private String	row_172;
	private String	row_173;
	private String	row_174;
	private String	row_175;
	private String	row_176;
	private String	row_177;
	private String	row_178;
	private String	row_179;
	private String	row_180;
	private String	row_181;
	private String	row_182;
	private String	row_183;
	private String	row_184;
	private String	row_185;
	private String	row_186;
	private String	row_187;
	private String	row_188;
	private String	row_189;
	private String	row_190;
	private String	row_191;
	private String	row_192;
	private String	row_193;
	private String	row_194;
	private String	row_195;
	private String	row_196;
	private String	row_197;
	private String	row_198;
	private String	row_199;
	private String	row_200;
	private String	del_flg;
	private String	entity_flg;
	private String	modify_flg;
	private String	entry_user;
	private String	modify_user;
	private String	auth_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	auth_time;
	private String	report_version;
	private Date	start_date;
	private String	level_1;
	private String	level_2;
	private String	filed_desc;
	private String	row_201;
	private String	row_202;
	private String	row_203;
	private String	row_204;
	private String	row_205;
	private String	row_206;
	private String	row_207;
	private String	row_208;
	private String	row_209;
	private String	row_210;
	private String	row_211;
	private String	row_212;
	private String	row_213;
	private String	row_214;
	private String	row_215;
	private String	row_216;
	private String	row_217;
	private String	row_218;
	private String	row_219;
	private String	row_220;
	private String	row_221;
	private String	row_222;
	private String	row_223;
	private String	row_224;
	private String	row_225;
	private String	row_226;
	private String	row_227;
	private String	row_228;
	private String	row_229;
	private String	row_230;
	private String	row_231;
	private String	row_232;
	private String	row_233;
	private String	row_234;
	private String	row_235;
	private String	row_236;
	private String	row_237;
	private String	row_238;
	private String	row_239;
	private String	row_240;
	private String	row_241;
	private String	row_242;
	private String	row_243;
	private String	row_244;
	private String	row_245;
	private String	row_246;
	private String	row_247;
	private String	row_248;
	private String	row_249;
	private String	row_250;
	private String	row_251;
	private String	row_252;
	
	private String	row_253;
	private String	row_254;
	private String	row_255;
	private String	row_256;
	private String	row_257;
	private String	row_258;
	private String	row_259;
	private String	row_260;
	private String	row_261;
	private String	row_262;
	private String	row_263;
	private String	row_264;
	private String	row_265;
	private String	row_266;
	private String	row_267;
	private String	row_268;
	private String	row_269;
	private String	row_270;
	private String	row_271;
	private String	row_272;
	private String	row_273;
	private String	row_274;
	private String	row_275;
	private String	row_276;
	private String	row_277;
	private String	row_278;
	private String	row_279;
	private String	row_280;
	private String	row_281;
	private String	row_282;
	private String	row_283;
	private String	row_284;
	private String	row_285;
	private String	row_286;
	private String	row_287;
	private String	row_288;
	private String	row_289;
	private String	row_290;
	private String	row_291;
	private String	row_292;
	private String	row_293;
	private String	row_294;
	private String	row_295;
	private String	row_296;
	private String	row_297;
	private String	row_298;
	private String	row_299;
	private String	row_300;
	private String	row_301;
	private String	row_302;
	private String	row_303;
	private String	row_304;
	private String	row_305;
	private String	row_306;
	private String	row_307;
	private String	row_308;
	private String	row_309;
	private String	row_310;
	private String	row_311;
	private String	row_312;
	private String	row_313;
	private String	row_314;
	private String	row_315;
	private String	row_316;
	private String	row_317;
	private String	row_318;
	private String	row_319;
	private String	row_320;
	private String	row_321;
	private String	row_322;
	private String	row_323;
	private String	row_324;
	private String	row_325;
	private String	row_326;
	private String	row_327;
	private String	row_328;
	private String	row_329;
	private String	row_330;
	private String	row_331;
	private String	row_332;
	private String	row_333;
	private String	row_334;
	private String	row_335;
	private String	row_336;
	private String	row_337;
	private String	row_338;
	private String	row_339;
	private String	row_340;
	private String	row_341;
	private String	row_342;
	private String	row_343;
	private String	row_344;
	private String	row_345;
	private String	row_346;
	private String	row_347;
	private String	row_348;
	private String	row_349;
	private String	row_350;
	private String	row_351;
	private String	row_352;
	private String	row_353;
	private String	row_354;
	private String	row_355;
	private String	row_356;
	private String	row_357;
	private String	row_358;
	private String	row_359;
	private String	row_360;
	private String	row_361;
	private String	row_362;
	private String	row_363;
	private String	row_364;
	private String	row_365;
	private String	row_366;
	private String	row_367;
	private String	row_368;
	private String	row_369;
	private String	row_370;
	private String	row_371;
	private String	row_372;
	private String	row_373;
	private String	row_374;
	private String	row_375;
	private String	row_376;
	private String	row_377;
	private String	row_378;
	private String	row_379;
	private String	row_380;
	private String	row_381;
	private String	row_382;
	private String	row_383;
	private String	row_384;
	private String	row_385;
	private String	row_386;
	private String	row_387;
	private String	row_388;
	private String	row_389;
	private String	row_390;
	private String	row_391;
	private String	row_392;
	private String	row_393;
	private String	row_394;
	private String	row_395;
	private String	row_396;
	private String	row_397;
	private String	row_398;
	private String	row_399;
	private String	row_400;
	private String	row_401;
	private String	row_402;
	private String	row_403;
	private String	row_404;
	private String	row_405;
	private String	row_406;
	private String	row_407;
	private String	row_408;
	private String	row_409;
	private String	row_410;
	private String	row_411;
	private String	row_412;
	private String	row_413;
	private String	row_414;
	private String	row_415;
	private String	row_416;
	private String	row_417;
	private String	row_418;
	private String	row_419;
	private String	row_420;
	private String	row_421;
	private String	row_422;
	private String	row_423;
	private String	row_424;
	private String	row_425;
	private String	row_426;
	private String	row_427;
	private String	row_428;
	private String	row_429;
	private String	row_430;
	private String	row_431;
	private String	row_432;
	private String	row_433;
	private String	row_434;
	private String	row_435;
	private String	row_436;
	private String	row_437;
	private String	row_438;
	private String	row_439;
	private String	row_440;
	private String	row_441;
	private String	row_442;
	private String	row_443;
	private String	row_444;
	private String	row_445;
	private String	row_446;
	private String	row_447;
	private String	row_448;
	private String	row_449;
	private String	row_450;
	private String	row_451;
	private String	row_452;
	private String	row_453;
	private String	row_454;
	private String	row_455;
	private String	row_456;
	private String	row_457;
	private String	row_458;
	private String	row_459;
	private String	row_460;
	private String	row_461;
	private String	row_462;
	private String	row_463;
	private String	row_464;
	private String	row_465;
	private String	row_466;
	private String	row_467;
	private String	row_468;
	private String	row_469;
	private String	row_470;
	private String	row_471;
	private String	row_472;
	private String	row_473;
	private String	row_474;
	private String	row_475;
	private String	row_476;
	private String	row_477;
	private String	row_478;
	private String	row_479;
	private String	row_480;
	private String	row_481;
	private String	row_482;
	private String	row_483;
	private String	row_484;
	private String	row_485;
	private String	row_486;
	private String	row_487;
	private String	row_488;
	private String	row_489;
	private String	row_490;
	private String	row_491;
	private String	row_492;
	private String	row_493;
	private String	row_494;
	private String	row_495;
	private String	row_496;
	private String	row_497;
	private String	row_498;
	private String	row_499;
	private String	row_500;
	private String	row_501;
	private String	row_502;
	private String	row_503;
	private String	row_504;
	
	

	public String getRow_253() {
		return row_253;
	}
	public void setRow_253(String row_253) {
		this.row_253 = row_253;
	}
	public String getRow_254() {
		return row_254;
	}
	public void setRow_254(String row_254) {
		this.row_254 = row_254;
	}
	public String getRow_255() {
		return row_255;
	}
	public void setRow_255(String row_255) {
		this.row_255 = row_255;
	}
	public String getRow_256() {
		return row_256;
	}
	public void setRow_256(String row_256) {
		this.row_256 = row_256;
	}
	public String getRow_257() {
		return row_257;
	}
	public void setRow_257(String row_257) {
		this.row_257 = row_257;
	}
	public String getRow_258() {
		return row_258;
	}
	public void setRow_258(String row_258) {
		this.row_258 = row_258;
	}
	public String getRow_259() {
		return row_259;
	}
	public void setRow_259(String row_259) {
		this.row_259 = row_259;
	}
	public String getRow_260() {
		return row_260;
	}
	public void setRow_260(String row_260) {
		this.row_260 = row_260;
	}
	public String getRow_261() {
		return row_261;
	}
	public void setRow_261(String row_261) {
		this.row_261 = row_261;
	}
	public String getRow_262() {
		return row_262;
	}
	public void setRow_262(String row_262) {
		this.row_262 = row_262;
	}
	public String getRow_263() {
		return row_263;
	}
	public void setRow_263(String row_263) {
		this.row_263 = row_263;
	}
	public String getRow_264() {
		return row_264;
	}
	public void setRow_264(String row_264) {
		this.row_264 = row_264;
	}
	public String getRow_265() {
		return row_265;
	}
	public void setRow_265(String row_265) {
		this.row_265 = row_265;
	}
	public String getRow_266() {
		return row_266;
	}
	public void setRow_266(String row_266) {
		this.row_266 = row_266;
	}
	public String getRow_267() {
		return row_267;
	}
	public void setRow_267(String row_267) {
		this.row_267 = row_267;
	}
	public String getRow_268() {
		return row_268;
	}
	public void setRow_268(String row_268) {
		this.row_268 = row_268;
	}
	public String getRow_269() {
		return row_269;
	}
	public void setRow_269(String row_269) {
		this.row_269 = row_269;
	}
	public String getRow_270() {
		return row_270;
	}
	public void setRow_270(String row_270) {
		this.row_270 = row_270;
	}
	public String getRow_271() {
		return row_271;
	}
	public void setRow_271(String row_271) {
		this.row_271 = row_271;
	}
	public String getRow_272() {
		return row_272;
	}
	public void setRow_272(String row_272) {
		this.row_272 = row_272;
	}
	public String getRow_273() {
		return row_273;
	}
	public void setRow_273(String row_273) {
		this.row_273 = row_273;
	}
	public String getRow_274() {
		return row_274;
	}
	public void setRow_274(String row_274) {
		this.row_274 = row_274;
	}
	public String getRow_275() {
		return row_275;
	}
	public void setRow_275(String row_275) {
		this.row_275 = row_275;
	}
	public String getRow_276() {
		return row_276;
	}
	public void setRow_276(String row_276) {
		this.row_276 = row_276;
	}
	public String getRow_277() {
		return row_277;
	}
	public void setRow_277(String row_277) {
		this.row_277 = row_277;
	}
	public String getRow_278() {
		return row_278;
	}
	public void setRow_278(String row_278) {
		this.row_278 = row_278;
	}
	public String getRow_279() {
		return row_279;
	}
	public void setRow_279(String row_279) {
		this.row_279 = row_279;
	}
	public String getRow_280() {
		return row_280;
	}
	public void setRow_280(String row_280) {
		this.row_280 = row_280;
	}
	public String getRow_281() {
		return row_281;
	}
	public void setRow_281(String row_281) {
		this.row_281 = row_281;
	}
	public String getRow_282() {
		return row_282;
	}
	public void setRow_282(String row_282) {
		this.row_282 = row_282;
	}
	public String getRow_283() {
		return row_283;
	}
	public void setRow_283(String row_283) {
		this.row_283 = row_283;
	}
	public String getRow_284() {
		return row_284;
	}
	public void setRow_284(String row_284) {
		this.row_284 = row_284;
	}
	public String getRow_285() {
		return row_285;
	}
	public void setRow_285(String row_285) {
		this.row_285 = row_285;
	}
	public String getRow_286() {
		return row_286;
	}
	public void setRow_286(String row_286) {
		this.row_286 = row_286;
	}
	public String getRow_287() {
		return row_287;
	}
	public void setRow_287(String row_287) {
		this.row_287 = row_287;
	}
	public String getRow_288() {
		return row_288;
	}
	public void setRow_288(String row_288) {
		this.row_288 = row_288;
	}
	public String getRow_289() {
		return row_289;
	}
	public void setRow_289(String row_289) {
		this.row_289 = row_289;
	}
	public String getRow_290() {
		return row_290;
	}
	public void setRow_290(String row_290) {
		this.row_290 = row_290;
	}
	public String getRow_291() {
		return row_291;
	}
	public void setRow_291(String row_291) {
		this.row_291 = row_291;
	}
	public String getRow_292() {
		return row_292;
	}
	public void setRow_292(String row_292) {
		this.row_292 = row_292;
	}
	public String getRow_293() {
		return row_293;
	}
	public void setRow_293(String row_293) {
		this.row_293 = row_293;
	}
	public String getRow_294() {
		return row_294;
	}
	public void setRow_294(String row_294) {
		this.row_294 = row_294;
	}
	public String getRow_295() {
		return row_295;
	}
	public void setRow_295(String row_295) {
		this.row_295 = row_295;
	}
	public String getRow_296() {
		return row_296;
	}
	public void setRow_296(String row_296) {
		this.row_296 = row_296;
	}
	public String getRow_297() {
		return row_297;
	}
	public void setRow_297(String row_297) {
		this.row_297 = row_297;
	}
	public String getRow_298() {
		return row_298;
	}
	public void setRow_298(String row_298) {
		this.row_298 = row_298;
	}
	public String getRow_299() {
		return row_299;
	}
	public void setRow_299(String row_299) {
		this.row_299 = row_299;
	}
	public String getRow_300() {
		return row_300;
	}
	public void setRow_300(String row_300) {
		this.row_300 = row_300;
	}
	public String getRow_301() {
		return row_301;
	}
	public void setRow_301(String row_301) {
		this.row_301 = row_301;
	}
	public String getRow_302() {
		return row_302;
	}
	public void setRow_302(String row_302) {
		this.row_302 = row_302;
	}
	public String getRow_303() {
		return row_303;
	}
	public void setRow_303(String row_303) {
		this.row_303 = row_303;
	}
	public String getRow_304() {
		return row_304;
	}
	public void setRow_304(String row_304) {
		this.row_304 = row_304;
	}
	public String getRow_305() {
		return row_305;
	}
	public void setRow_305(String row_305) {
		this.row_305 = row_305;
	}
	public String getRow_306() {
		return row_306;
	}
	public void setRow_306(String row_306) {
		this.row_306 = row_306;
	}
	public String getRow_307() {
		return row_307;
	}
	public void setRow_307(String row_307) {
		this.row_307 = row_307;
	}
	public String getRow_308() {
		return row_308;
	}
	public void setRow_308(String row_308) {
		this.row_308 = row_308;
	}
	public String getRow_309() {
		return row_309;
	}
	public void setRow_309(String row_309) {
		this.row_309 = row_309;
	}
	public String getRow_310() {
		return row_310;
	}
	public void setRow_310(String row_310) {
		this.row_310 = row_310;
	}
	public String getRow_311() {
		return row_311;
	}
	public void setRow_311(String row_311) {
		this.row_311 = row_311;
	}
	public String getRow_312() {
		return row_312;
	}
	public void setRow_312(String row_312) {
		this.row_312 = row_312;
	}
	public String getRow_313() {
		return row_313;
	}
	public void setRow_313(String row_313) {
		this.row_313 = row_313;
	}
	public String getRow_314() {
		return row_314;
	}
	public void setRow_314(String row_314) {
		this.row_314 = row_314;
	}
	public String getRow_315() {
		return row_315;
	}
	public void setRow_315(String row_315) {
		this.row_315 = row_315;
	}
	public String getRow_316() {
		return row_316;
	}
	public void setRow_316(String row_316) {
		this.row_316 = row_316;
	}
	public String getRow_317() {
		return row_317;
	}
	public void setRow_317(String row_317) {
		this.row_317 = row_317;
	}
	public String getRow_318() {
		return row_318;
	}
	public void setRow_318(String row_318) {
		this.row_318 = row_318;
	}
	public String getRow_319() {
		return row_319;
	}
	public void setRow_319(String row_319) {
		this.row_319 = row_319;
	}
	public String getRow_320() {
		return row_320;
	}
	public void setRow_320(String row_320) {
		this.row_320 = row_320;
	}
	public String getRow_321() {
		return row_321;
	}
	public void setRow_321(String row_321) {
		this.row_321 = row_321;
	}
	public String getRow_322() {
		return row_322;
	}
	public void setRow_322(String row_322) {
		this.row_322 = row_322;
	}
	public String getRow_323() {
		return row_323;
	}
	public void setRow_323(String row_323) {
		this.row_323 = row_323;
	}
	public String getRow_324() {
		return row_324;
	}
	public void setRow_324(String row_324) {
		this.row_324 = row_324;
	}
	public String getRow_325() {
		return row_325;
	}
	public void setRow_325(String row_325) {
		this.row_325 = row_325;
	}
	public String getRow_326() {
		return row_326;
	}
	public void setRow_326(String row_326) {
		this.row_326 = row_326;
	}
	public String getRow_327() {
		return row_327;
	}
	public void setRow_327(String row_327) {
		this.row_327 = row_327;
	}
	public String getRow_328() {
		return row_328;
	}
	public void setRow_328(String row_328) {
		this.row_328 = row_328;
	}
	public String getRow_329() {
		return row_329;
	}
	public void setRow_329(String row_329) {
		this.row_329 = row_329;
	}
	public String getRow_330() {
		return row_330;
	}
	public void setRow_330(String row_330) {
		this.row_330 = row_330;
	}
	public String getRow_331() {
		return row_331;
	}
	public void setRow_331(String row_331) {
		this.row_331 = row_331;
	}
	public String getRow_332() {
		return row_332;
	}
	public void setRow_332(String row_332) {
		this.row_332 = row_332;
	}
	public String getRow_333() {
		return row_333;
	}
	public void setRow_333(String row_333) {
		this.row_333 = row_333;
	}
	public String getRow_334() {
		return row_334;
	}
	public void setRow_334(String row_334) {
		this.row_334 = row_334;
	}
	public String getRow_335() {
		return row_335;
	}
	public void setRow_335(String row_335) {
		this.row_335 = row_335;
	}
	public String getRow_336() {
		return row_336;
	}
	public void setRow_336(String row_336) {
		this.row_336 = row_336;
	}
	public String getRow_337() {
		return row_337;
	}
	public void setRow_337(String row_337) {
		this.row_337 = row_337;
	}
	public String getRow_338() {
		return row_338;
	}
	public void setRow_338(String row_338) {
		this.row_338 = row_338;
	}
	public String getRow_339() {
		return row_339;
	}
	public void setRow_339(String row_339) {
		this.row_339 = row_339;
	}
	public String getRow_340() {
		return row_340;
	}
	public void setRow_340(String row_340) {
		this.row_340 = row_340;
	}
	public String getRow_341() {
		return row_341;
	}
	public void setRow_341(String row_341) {
		this.row_341 = row_341;
	}
	public String getRow_342() {
		return row_342;
	}
	public void setRow_342(String row_342) {
		this.row_342 = row_342;
	}
	public String getRow_343() {
		return row_343;
	}
	public void setRow_343(String row_343) {
		this.row_343 = row_343;
	}
	public String getRow_344() {
		return row_344;
	}
	public void setRow_344(String row_344) {
		this.row_344 = row_344;
	}
	public String getRow_345() {
		return row_345;
	}
	public void setRow_345(String row_345) {
		this.row_345 = row_345;
	}
	public String getRow_346() {
		return row_346;
	}
	public void setRow_346(String row_346) {
		this.row_346 = row_346;
	}
	public String getRow_347() {
		return row_347;
	}
	public void setRow_347(String row_347) {
		this.row_347 = row_347;
	}
	public String getRow_348() {
		return row_348;
	}
	public void setRow_348(String row_348) {
		this.row_348 = row_348;
	}
	public String getRow_349() {
		return row_349;
	}
	public void setRow_349(String row_349) {
		this.row_349 = row_349;
	}
	public String getRow_350() {
		return row_350;
	}
	public void setRow_350(String row_350) {
		this.row_350 = row_350;
	}
	public String getRow_351() {
		return row_351;
	}
	public void setRow_351(String row_351) {
		this.row_351 = row_351;
	}
	public String getRow_352() {
		return row_352;
	}
	public void setRow_352(String row_352) {
		this.row_352 = row_352;
	}
	public String getRow_353() {
		return row_353;
	}
	public void setRow_353(String row_353) {
		this.row_353 = row_353;
	}
	public String getRow_354() {
		return row_354;
	}
	public void setRow_354(String row_354) {
		this.row_354 = row_354;
	}
	public String getRow_355() {
		return row_355;
	}
	public void setRow_355(String row_355) {
		this.row_355 = row_355;
	}
	public String getRow_356() {
		return row_356;
	}
	public void setRow_356(String row_356) {
		this.row_356 = row_356;
	}
	public String getRow_357() {
		return row_357;
	}
	public void setRow_357(String row_357) {
		this.row_357 = row_357;
	}
	public String getRow_358() {
		return row_358;
	}
	public void setRow_358(String row_358) {
		this.row_358 = row_358;
	}
	public String getRow_359() {
		return row_359;
	}
	public void setRow_359(String row_359) {
		this.row_359 = row_359;
	}
	public String getRow_360() {
		return row_360;
	}
	public void setRow_360(String row_360) {
		this.row_360 = row_360;
	}
	public String getRow_361() {
		return row_361;
	}
	public void setRow_361(String row_361) {
		this.row_361 = row_361;
	}
	public String getRow_362() {
		return row_362;
	}
	public void setRow_362(String row_362) {
		this.row_362 = row_362;
	}
	public String getRow_363() {
		return row_363;
	}
	public void setRow_363(String row_363) {
		this.row_363 = row_363;
	}
	public String getRow_364() {
		return row_364;
	}
	public void setRow_364(String row_364) {
		this.row_364 = row_364;
	}
	public String getRow_365() {
		return row_365;
	}
	public void setRow_365(String row_365) {
		this.row_365 = row_365;
	}
	public String getRow_366() {
		return row_366;
	}
	public void setRow_366(String row_366) {
		this.row_366 = row_366;
	}
	public String getRow_367() {
		return row_367;
	}
	public void setRow_367(String row_367) {
		this.row_367 = row_367;
	}
	public String getRow_368() {
		return row_368;
	}
	public void setRow_368(String row_368) {
		this.row_368 = row_368;
	}
	public String getRow_369() {
		return row_369;
	}
	public void setRow_369(String row_369) {
		this.row_369 = row_369;
	}
	public String getRow_370() {
		return row_370;
	}
	public void setRow_370(String row_370) {
		this.row_370 = row_370;
	}
	public String getRow_371() {
		return row_371;
	}
	public void setRow_371(String row_371) {
		this.row_371 = row_371;
	}
	public String getRow_372() {
		return row_372;
	}
	public void setRow_372(String row_372) {
		this.row_372 = row_372;
	}
	public String getRow_373() {
		return row_373;
	}
	public void setRow_373(String row_373) {
		this.row_373 = row_373;
	}
	public String getRow_374() {
		return row_374;
	}
	public void setRow_374(String row_374) {
		this.row_374 = row_374;
	}
	public String getRow_375() {
		return row_375;
	}
	public void setRow_375(String row_375) {
		this.row_375 = row_375;
	}
	public String getRow_376() {
		return row_376;
	}
	public void setRow_376(String row_376) {
		this.row_376 = row_376;
	}
	public String getRow_377() {
		return row_377;
	}
	public void setRow_377(String row_377) {
		this.row_377 = row_377;
	}
	public String getRow_378() {
		return row_378;
	}
	public void setRow_378(String row_378) {
		this.row_378 = row_378;
	}
	public String getRow_379() {
		return row_379;
	}
	public void setRow_379(String row_379) {
		this.row_379 = row_379;
	}
	public String getRow_380() {
		return row_380;
	}
	public void setRow_380(String row_380) {
		this.row_380 = row_380;
	}
	public String getRow_381() {
		return row_381;
	}
	public void setRow_381(String row_381) {
		this.row_381 = row_381;
	}
	public String getRow_382() {
		return row_382;
	}
	public void setRow_382(String row_382) {
		this.row_382 = row_382;
	}
	public String getRow_383() {
		return row_383;
	}
	public void setRow_383(String row_383) {
		this.row_383 = row_383;
	}
	public String getRow_384() {
		return row_384;
	}
	public void setRow_384(String row_384) {
		this.row_384 = row_384;
	}
	public String getRow_385() {
		return row_385;
	}
	public void setRow_385(String row_385) {
		this.row_385 = row_385;
	}
	public String getRow_386() {
		return row_386;
	}
	public void setRow_386(String row_386) {
		this.row_386 = row_386;
	}
	public String getRow_387() {
		return row_387;
	}
	public void setRow_387(String row_387) {
		this.row_387 = row_387;
	}
	public String getRow_388() {
		return row_388;
	}
	public void setRow_388(String row_388) {
		this.row_388 = row_388;
	}
	public String getRow_389() {
		return row_389;
	}
	public void setRow_389(String row_389) {
		this.row_389 = row_389;
	}
	public String getRow_390() {
		return row_390;
	}
	public void setRow_390(String row_390) {
		this.row_390 = row_390;
	}
	public String getRow_391() {
		return row_391;
	}
	public void setRow_391(String row_391) {
		this.row_391 = row_391;
	}
	public String getRow_392() {
		return row_392;
	}
	public void setRow_392(String row_392) {
		this.row_392 = row_392;
	}
	public String getRow_393() {
		return row_393;
	}
	public void setRow_393(String row_393) {
		this.row_393 = row_393;
	}
	public String getRow_394() {
		return row_394;
	}
	public void setRow_394(String row_394) {
		this.row_394 = row_394;
	}
	public String getRow_395() {
		return row_395;
	}
	public void setRow_395(String row_395) {
		this.row_395 = row_395;
	}
	public String getRow_396() {
		return row_396;
	}
	public void setRow_396(String row_396) {
		this.row_396 = row_396;
	}
	public String getRow_397() {
		return row_397;
	}
	public void setRow_397(String row_397) {
		this.row_397 = row_397;
	}
	public String getRow_398() {
		return row_398;
	}
	public void setRow_398(String row_398) {
		this.row_398 = row_398;
	}
	public String getRow_399() {
		return row_399;
	}
	public void setRow_399(String row_399) {
		this.row_399 = row_399;
	}
	public String getRow_400() {
		return row_400;
	}
	public void setRow_400(String row_400) {
		this.row_400 = row_400;
	}
	public String getRow_401() {
		return row_401;
	}
	public void setRow_401(String row_401) {
		this.row_401 = row_401;
	}
	public String getRow_402() {
		return row_402;
	}
	public void setRow_402(String row_402) {
		this.row_402 = row_402;
	}
	public String getRow_403() {
		return row_403;
	}
	public void setRow_403(String row_403) {
		this.row_403 = row_403;
	}
	public String getRow_404() {
		return row_404;
	}
	public void setRow_404(String row_404) {
		this.row_404 = row_404;
	}
	public String getRow_405() {
		return row_405;
	}
	public void setRow_405(String row_405) {
		this.row_405 = row_405;
	}
	public String getRow_406() {
		return row_406;
	}
	public void setRow_406(String row_406) {
		this.row_406 = row_406;
	}
	public String getRow_407() {
		return row_407;
	}
	public void setRow_407(String row_407) {
		this.row_407 = row_407;
	}
	public String getRow_408() {
		return row_408;
	}
	public void setRow_408(String row_408) {
		this.row_408 = row_408;
	}
	public String getRow_409() {
		return row_409;
	}
	public void setRow_409(String row_409) {
		this.row_409 = row_409;
	}
	public String getRow_410() {
		return row_410;
	}
	public void setRow_410(String row_410) {
		this.row_410 = row_410;
	}
	public String getRow_411() {
		return row_411;
	}
	public void setRow_411(String row_411) {
		this.row_411 = row_411;
	}
	public String getRow_412() {
		return row_412;
	}
	public void setRow_412(String row_412) {
		this.row_412 = row_412;
	}
	public String getRow_413() {
		return row_413;
	}
	public void setRow_413(String row_413) {
		this.row_413 = row_413;
	}
	public String getRow_414() {
		return row_414;
	}
	public void setRow_414(String row_414) {
		this.row_414 = row_414;
	}
	public String getRow_415() {
		return row_415;
	}
	public void setRow_415(String row_415) {
		this.row_415 = row_415;
	}
	public String getRow_416() {
		return row_416;
	}
	public void setRow_416(String row_416) {
		this.row_416 = row_416;
	}
	public String getRow_417() {
		return row_417;
	}
	public void setRow_417(String row_417) {
		this.row_417 = row_417;
	}
	public String getRow_418() {
		return row_418;
	}
	public void setRow_418(String row_418) {
		this.row_418 = row_418;
	}
	public String getRow_419() {
		return row_419;
	}
	public void setRow_419(String row_419) {
		this.row_419 = row_419;
	}
	public String getRow_420() {
		return row_420;
	}
	public void setRow_420(String row_420) {
		this.row_420 = row_420;
	}
	public String getRow_421() {
		return row_421;
	}
	public void setRow_421(String row_421) {
		this.row_421 = row_421;
	}
	public String getRow_422() {
		return row_422;
	}
	public void setRow_422(String row_422) {
		this.row_422 = row_422;
	}
	public String getRow_423() {
		return row_423;
	}
	public void setRow_423(String row_423) {
		this.row_423 = row_423;
	}
	public String getRow_424() {
		return row_424;
	}
	public void setRow_424(String row_424) {
		this.row_424 = row_424;
	}
	public String getRow_425() {
		return row_425;
	}
	public void setRow_425(String row_425) {
		this.row_425 = row_425;
	}
	public String getRow_426() {
		return row_426;
	}
	public void setRow_426(String row_426) {
		this.row_426 = row_426;
	}
	public String getRow_427() {
		return row_427;
	}
	public void setRow_427(String row_427) {
		this.row_427 = row_427;
	}
	public String getRow_428() {
		return row_428;
	}
	public void setRow_428(String row_428) {
		this.row_428 = row_428;
	}
	public String getRow_429() {
		return row_429;
	}
	public void setRow_429(String row_429) {
		this.row_429 = row_429;
	}
	public String getRow_430() {
		return row_430;
	}
	public void setRow_430(String row_430) {
		this.row_430 = row_430;
	}
	public String getRow_431() {
		return row_431;
	}
	public void setRow_431(String row_431) {
		this.row_431 = row_431;
	}
	public String getRow_432() {
		return row_432;
	}
	public void setRow_432(String row_432) {
		this.row_432 = row_432;
	}
	public String getRow_433() {
		return row_433;
	}
	public void setRow_433(String row_433) {
		this.row_433 = row_433;
	}
	public String getRow_434() {
		return row_434;
	}
	public void setRow_434(String row_434) {
		this.row_434 = row_434;
	}
	public String getRow_435() {
		return row_435;
	}
	public void setRow_435(String row_435) {
		this.row_435 = row_435;
	}
	public String getRow_436() {
		return row_436;
	}
	public void setRow_436(String row_436) {
		this.row_436 = row_436;
	}
	public String getRow_437() {
		return row_437;
	}
	public void setRow_437(String row_437) {
		this.row_437 = row_437;
	}
	public String getRow_438() {
		return row_438;
	}
	public void setRow_438(String row_438) {
		this.row_438 = row_438;
	}
	public String getRow_439() {
		return row_439;
	}
	public void setRow_439(String row_439) {
		this.row_439 = row_439;
	}
	public String getRow_440() {
		return row_440;
	}
	public void setRow_440(String row_440) {
		this.row_440 = row_440;
	}
	public String getRow_441() {
		return row_441;
	}
	public void setRow_441(String row_441) {
		this.row_441 = row_441;
	}
	public String getRow_442() {
		return row_442;
	}
	public void setRow_442(String row_442) {
		this.row_442 = row_442;
	}
	public String getRow_443() {
		return row_443;
	}
	public void setRow_443(String row_443) {
		this.row_443 = row_443;
	}
	public String getRow_444() {
		return row_444;
	}
	public void setRow_444(String row_444) {
		this.row_444 = row_444;
	}
	public String getRow_445() {
		return row_445;
	}
	public void setRow_445(String row_445) {
		this.row_445 = row_445;
	}
	public String getRow_446() {
		return row_446;
	}
	public void setRow_446(String row_446) {
		this.row_446 = row_446;
	}
	public String getRow_447() {
		return row_447;
	}
	public void setRow_447(String row_447) {
		this.row_447 = row_447;
	}
	public String getRow_448() {
		return row_448;
	}
	public void setRow_448(String row_448) {
		this.row_448 = row_448;
	}
	public String getRow_449() {
		return row_449;
	}
	public void setRow_449(String row_449) {
		this.row_449 = row_449;
	}
	public String getRow_450() {
		return row_450;
	}
	public void setRow_450(String row_450) {
		this.row_450 = row_450;
	}
	public String getRow_451() {
		return row_451;
	}
	public void setRow_451(String row_451) {
		this.row_451 = row_451;
	}
	public String getRow_452() {
		return row_452;
	}
	public void setRow_452(String row_452) {
		this.row_452 = row_452;
	}
	public String getRow_453() {
		return row_453;
	}
	public void setRow_453(String row_453) {
		this.row_453 = row_453;
	}
	public String getRow_454() {
		return row_454;
	}
	public void setRow_454(String row_454) {
		this.row_454 = row_454;
	}
	public String getRow_455() {
		return row_455;
	}
	public void setRow_455(String row_455) {
		this.row_455 = row_455;
	}
	public String getRow_456() {
		return row_456;
	}
	public void setRow_456(String row_456) {
		this.row_456 = row_456;
	}
	public String getRow_457() {
		return row_457;
	}
	public void setRow_457(String row_457) {
		this.row_457 = row_457;
	}
	public String getRow_458() {
		return row_458;
	}
	public void setRow_458(String row_458) {
		this.row_458 = row_458;
	}
	public String getRow_459() {
		return row_459;
	}
	public void setRow_459(String row_459) {
		this.row_459 = row_459;
	}
	public String getRow_460() {
		return row_460;
	}
	public void setRow_460(String row_460) {
		this.row_460 = row_460;
	}
	public String getRow_461() {
		return row_461;
	}
	public void setRow_461(String row_461) {
		this.row_461 = row_461;
	}
	public String getRow_462() {
		return row_462;
	}
	public void setRow_462(String row_462) {
		this.row_462 = row_462;
	}
	public String getRow_463() {
		return row_463;
	}
	public void setRow_463(String row_463) {
		this.row_463 = row_463;
	}
	public String getRow_464() {
		return row_464;
	}
	public void setRow_464(String row_464) {
		this.row_464 = row_464;
	}
	public String getRow_465() {
		return row_465;
	}
	public void setRow_465(String row_465) {
		this.row_465 = row_465;
	}
	public String getRow_466() {
		return row_466;
	}
	public void setRow_466(String row_466) {
		this.row_466 = row_466;
	}
	public String getRow_467() {
		return row_467;
	}
	public void setRow_467(String row_467) {
		this.row_467 = row_467;
	}
	public String getRow_468() {
		return row_468;
	}
	public void setRow_468(String row_468) {
		this.row_468 = row_468;
	}
	public String getRow_469() {
		return row_469;
	}
	public void setRow_469(String row_469) {
		this.row_469 = row_469;
	}
	public String getRow_470() {
		return row_470;
	}
	public void setRow_470(String row_470) {
		this.row_470 = row_470;
	}
	public String getRow_471() {
		return row_471;
	}
	public void setRow_471(String row_471) {
		this.row_471 = row_471;
	}
	public String getRow_472() {
		return row_472;
	}
	public void setRow_472(String row_472) {
		this.row_472 = row_472;
	}
	public String getRow_473() {
		return row_473;
	}
	public void setRow_473(String row_473) {
		this.row_473 = row_473;
	}
	public String getRow_474() {
		return row_474;
	}
	public void setRow_474(String row_474) {
		this.row_474 = row_474;
	}
	public String getRow_475() {
		return row_475;
	}
	public void setRow_475(String row_475) {
		this.row_475 = row_475;
	}
	public String getRow_476() {
		return row_476;
	}
	public void setRow_476(String row_476) {
		this.row_476 = row_476;
	}
	public String getRow_477() {
		return row_477;
	}
	public void setRow_477(String row_477) {
		this.row_477 = row_477;
	}
	public String getRow_478() {
		return row_478;
	}
	public void setRow_478(String row_478) {
		this.row_478 = row_478;
	}
	public String getRow_479() {
		return row_479;
	}
	public void setRow_479(String row_479) {
		this.row_479 = row_479;
	}
	public String getRow_480() {
		return row_480;
	}
	public void setRow_480(String row_480) {
		this.row_480 = row_480;
	}
	public String getRow_481() {
		return row_481;
	}
	public void setRow_481(String row_481) {
		this.row_481 = row_481;
	}
	public String getRow_482() {
		return row_482;
	}
	public void setRow_482(String row_482) {
		this.row_482 = row_482;
	}
	public String getRow_483() {
		return row_483;
	}
	public void setRow_483(String row_483) {
		this.row_483 = row_483;
	}
	public String getRow_484() {
		return row_484;
	}
	public void setRow_484(String row_484) {
		this.row_484 = row_484;
	}
	public String getRow_485() {
		return row_485;
	}
	public void setRow_485(String row_485) {
		this.row_485 = row_485;
	}
	public String getRow_486() {
		return row_486;
	}
	public void setRow_486(String row_486) {
		this.row_486 = row_486;
	}
	public String getRow_487() {
		return row_487;
	}
	public void setRow_487(String row_487) {
		this.row_487 = row_487;
	}
	public String getRow_488() {
		return row_488;
	}
	public void setRow_488(String row_488) {
		this.row_488 = row_488;
	}
	public String getRow_489() {
		return row_489;
	}
	public void setRow_489(String row_489) {
		this.row_489 = row_489;
	}
	public String getRow_490() {
		return row_490;
	}
	public void setRow_490(String row_490) {
		this.row_490 = row_490;
	}
	public String getRow_491() {
		return row_491;
	}
	public void setRow_491(String row_491) {
		this.row_491 = row_491;
	}
	public String getRow_492() {
		return row_492;
	}
	public void setRow_492(String row_492) {
		this.row_492 = row_492;
	}
	public String getRow_493() {
		return row_493;
	}
	public void setRow_493(String row_493) {
		this.row_493 = row_493;
	}
	public String getRow_494() {
		return row_494;
	}
	public void setRow_494(String row_494) {
		this.row_494 = row_494;
	}
	public String getRow_495() {
		return row_495;
	}
	public void setRow_495(String row_495) {
		this.row_495 = row_495;
	}
	public String getRow_496() {
		return row_496;
	}
	public void setRow_496(String row_496) {
		this.row_496 = row_496;
	}
	public String getRow_497() {
		return row_497;
	}
	public void setRow_497(String row_497) {
		this.row_497 = row_497;
	}
	public String getRow_498() {
		return row_498;
	}
	public void setRow_498(String row_498) {
		this.row_498 = row_498;
	}
	public String getRow_499() {
		return row_499;
	}
	public void setRow_499(String row_499) {
		this.row_499 = row_499;
	}
	public String getRow_500() {
		return row_500;
	}
	public void setRow_500(String row_500) {
		this.row_500 = row_500;
	}
	public String getRow_501() {
		return row_501;
	}
	public void setRow_501(String row_501) {
		this.row_501 = row_501;
	}
	public String getRow_502() {
		return row_502;
	}
	public void setRow_502(String row_502) {
		this.row_502 = row_502;
	}
	public String getRow_503() {
		return row_503;
	}
	public void setRow_503(String row_503) {
		this.row_503 = row_503;
	}
	public String getRow_504() {
		return row_504;
	}
	public void setRow_504(String row_504) {
		this.row_504 = row_504;
	}
	public String getReport_srl() {
		return report_srl;
	}
	public void setReport_srl(String report_srl) {
		this.report_srl = report_srl;
	}
	public Date getReport_version_date() {
		return report_version_date;
	}
	public void setReport_version_date(Date report_version_date) {
		this.report_version_date = report_version_date;
	}
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public String getReport_desc() {
		return report_desc;
	}
	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}
	public String getReport_category() {
		return report_category;
	}
	public void setReport_category(String report_category) {
		this.report_category = report_category;
	}
	public String getReport_frequency() {
		return report_frequency;
	}
	public void setReport_frequency(String report_frequency) {
		this.report_frequency = report_frequency;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public String getRow_101() {
		return row_101;
	}
	public void setRow_101(String row_101) {
		this.row_101 = row_101;
	}
	public String getRow_102() {
		return row_102;
	}
	public void setRow_102(String row_102) {
		this.row_102 = row_102;
	}
	public String getRow_103() {
		return row_103;
	}
	public void setRow_103(String row_103) {
		this.row_103 = row_103;
	}
	public String getRow_104() {
		return row_104;
	}
	public void setRow_104(String row_104) {
		this.row_104 = row_104;
	}
	public String getRow_105() {
		return row_105;
	}
	public void setRow_105(String row_105) {
		this.row_105 = row_105;
	}
	public String getRow_106() {
		return row_106;
	}
	public void setRow_106(String row_106) {
		this.row_106 = row_106;
	}
	public String getRow_107() {
		return row_107;
	}
	public void setRow_107(String row_107) {
		this.row_107 = row_107;
	}
	public String getRow_108() {
		return row_108;
	}
	public void setRow_108(String row_108) {
		this.row_108 = row_108;
	}
	public String getRow_109() {
		return row_109;
	}
	public void setRow_109(String row_109) {
		this.row_109 = row_109;
	}
	public String getRow_110() {
		return row_110;
	}
	public void setRow_110(String row_110) {
		this.row_110 = row_110;
	}
	public String getRow_111() {
		return row_111;
	}
	public void setRow_111(String row_111) {
		this.row_111 = row_111;
	}
	public String getRow_112() {
		return row_112;
	}
	public void setRow_112(String row_112) {
		this.row_112 = row_112;
	}
	public String getRow_113() {
		return row_113;
	}
	public void setRow_113(String row_113) {
		this.row_113 = row_113;
	}
	public String getRow_114() {
		return row_114;
	}
	public void setRow_114(String row_114) {
		this.row_114 = row_114;
	}
	public String getRow_115() {
		return row_115;
	}
	public void setRow_115(String row_115) {
		this.row_115 = row_115;
	}
	public String getRow_116() {
		return row_116;
	}
	public void setRow_116(String row_116) {
		this.row_116 = row_116;
	}
	public String getRow_117() {
		return row_117;
	}
	public void setRow_117(String row_117) {
		this.row_117 = row_117;
	}
	public String getRow_118() {
		return row_118;
	}
	public void setRow_118(String row_118) {
		this.row_118 = row_118;
	}
	public String getRow_119() {
		return row_119;
	}
	public void setRow_119(String row_119) {
		this.row_119 = row_119;
	}
	public String getRow_120() {
		return row_120;
	}
	public void setRow_120(String row_120) {
		this.row_120 = row_120;
	}
	public String getRow_121() {
		return row_121;
	}
	public void setRow_121(String row_121) {
		this.row_121 = row_121;
	}
	public String getRow_122() {
		return row_122;
	}
	public void setRow_122(String row_122) {
		this.row_122 = row_122;
	}
	public String getRow_123() {
		return row_123;
	}
	public void setRow_123(String row_123) {
		this.row_123 = row_123;
	}
	public String getRow_124() {
		return row_124;
	}
	public void setRow_124(String row_124) {
		this.row_124 = row_124;
	}
	public String getRow_125() {
		return row_125;
	}
	public void setRow_125(String row_125) {
		this.row_125 = row_125;
	}
	public String getRow_126() {
		return row_126;
	}
	public void setRow_126(String row_126) {
		this.row_126 = row_126;
	}
	public String getRow_127() {
		return row_127;
	}
	public void setRow_127(String row_127) {
		this.row_127 = row_127;
	}
	public String getRow_128() {
		return row_128;
	}
	public void setRow_128(String row_128) {
		this.row_128 = row_128;
	}
	public String getRow_129() {
		return row_129;
	}
	public void setRow_129(String row_129) {
		this.row_129 = row_129;
	}
	public String getRow_130() {
		return row_130;
	}
	public void setRow_130(String row_130) {
		this.row_130 = row_130;
	}
	public String getRow_131() {
		return row_131;
	}
	public void setRow_131(String row_131) {
		this.row_131 = row_131;
	}
	public String getRow_132() {
		return row_132;
	}
	public void setRow_132(String row_132) {
		this.row_132 = row_132;
	}
	public String getRow_133() {
		return row_133;
	}
	public void setRow_133(String row_133) {
		this.row_133 = row_133;
	}
	public String getRow_134() {
		return row_134;
	}
	public void setRow_134(String row_134) {
		this.row_134 = row_134;
	}
	public String getRow_135() {
		return row_135;
	}
	public void setRow_135(String row_135) {
		this.row_135 = row_135;
	}
	public String getRow_136() {
		return row_136;
	}
	public void setRow_136(String row_136) {
		this.row_136 = row_136;
	}
	public String getRow_137() {
		return row_137;
	}
	public void setRow_137(String row_137) {
		this.row_137 = row_137;
	}
	public String getRow_138() {
		return row_138;
	}
	public void setRow_138(String row_138) {
		this.row_138 = row_138;
	}
	public String getRow_139() {
		return row_139;
	}
	public void setRow_139(String row_139) {
		this.row_139 = row_139;
	}
	public String getRow_140() {
		return row_140;
	}
	public void setRow_140(String row_140) {
		this.row_140 = row_140;
	}
	public String getRow_141() {
		return row_141;
	}
	public void setRow_141(String row_141) {
		this.row_141 = row_141;
	}
	public String getRow_142() {
		return row_142;
	}
	public void setRow_142(String row_142) {
		this.row_142 = row_142;
	}
	public String getRow_143() {
		return row_143;
	}
	public void setRow_143(String row_143) {
		this.row_143 = row_143;
	}
	public String getRow_144() {
		return row_144;
	}
	public void setRow_144(String row_144) {
		this.row_144 = row_144;
	}
	public String getRow_145() {
		return row_145;
	}
	public void setRow_145(String row_145) {
		this.row_145 = row_145;
	}
	public String getRow_146() {
		return row_146;
	}
	public void setRow_146(String row_146) {
		this.row_146 = row_146;
	}
	public String getRow_147() {
		return row_147;
	}
	public void setRow_147(String row_147) {
		this.row_147 = row_147;
	}
	public String getRow_148() {
		return row_148;
	}
	public void setRow_148(String row_148) {
		this.row_148 = row_148;
	}
	public String getRow_149() {
		return row_149;
	}
	public void setRow_149(String row_149) {
		this.row_149 = row_149;
	}
	public String getRow_150() {
		return row_150;
	}
	public void setRow_150(String row_150) {
		this.row_150 = row_150;
	}
	public String getRow_151() {
		return row_151;
	}
	public void setRow_151(String row_151) {
		this.row_151 = row_151;
	}
	public String getRow_152() {
		return row_152;
	}
	public void setRow_152(String row_152) {
		this.row_152 = row_152;
	}
	public String getRow_153() {
		return row_153;
	}
	public void setRow_153(String row_153) {
		this.row_153 = row_153;
	}
	public String getRow_154() {
		return row_154;
	}
	public void setRow_154(String row_154) {
		this.row_154 = row_154;
	}
	public String getRow_155() {
		return row_155;
	}
	public void setRow_155(String row_155) {
		this.row_155 = row_155;
	}
	public String getRow_156() {
		return row_156;
	}
	public void setRow_156(String row_156) {
		this.row_156 = row_156;
	}
	public String getRow_157() {
		return row_157;
	}
	public void setRow_157(String row_157) {
		this.row_157 = row_157;
	}
	public String getRow_158() {
		return row_158;
	}
	public void setRow_158(String row_158) {
		this.row_158 = row_158;
	}
	public String getRow_159() {
		return row_159;
	}
	public void setRow_159(String row_159) {
		this.row_159 = row_159;
	}
	public String getRow_160() {
		return row_160;
	}
	public void setRow_160(String row_160) {
		this.row_160 = row_160;
	}
	public String getRow_161() {
		return row_161;
	}
	public void setRow_161(String row_161) {
		this.row_161 = row_161;
	}
	public String getRow_162() {
		return row_162;
	}
	public void setRow_162(String row_162) {
		this.row_162 = row_162;
	}
	public String getRow_163() {
		return row_163;
	}
	public void setRow_163(String row_163) {
		this.row_163 = row_163;
	}
	public String getRow_164() {
		return row_164;
	}
	public void setRow_164(String row_164) {
		this.row_164 = row_164;
	}
	public String getRow_165() {
		return row_165;
	}
	public void setRow_165(String row_165) {
		this.row_165 = row_165;
	}
	public String getRow_166() {
		return row_166;
	}
	public void setRow_166(String row_166) {
		this.row_166 = row_166;
	}
	public String getRow_167() {
		return row_167;
	}
	public void setRow_167(String row_167) {
		this.row_167 = row_167;
	}
	public String getRow_168() {
		return row_168;
	}
	public void setRow_168(String row_168) {
		this.row_168 = row_168;
	}
	public String getRow_169() {
		return row_169;
	}
	public void setRow_169(String row_169) {
		this.row_169 = row_169;
	}
	public String getRow_170() {
		return row_170;
	}
	public void setRow_170(String row_170) {
		this.row_170 = row_170;
	}
	public String getRow_171() {
		return row_171;
	}
	public void setRow_171(String row_171) {
		this.row_171 = row_171;
	}
	public String getRow_172() {
		return row_172;
	}
	public void setRow_172(String row_172) {
		this.row_172 = row_172;
	}
	public String getRow_173() {
		return row_173;
	}
	public void setRow_173(String row_173) {
		this.row_173 = row_173;
	}
	public String getRow_174() {
		return row_174;
	}
	public void setRow_174(String row_174) {
		this.row_174 = row_174;
	}
	public String getRow_175() {
		return row_175;
	}
	public void setRow_175(String row_175) {
		this.row_175 = row_175;
	}
	public String getRow_176() {
		return row_176;
	}
	public void setRow_176(String row_176) {
		this.row_176 = row_176;
	}
	public String getRow_177() {
		return row_177;
	}
	public void setRow_177(String row_177) {
		this.row_177 = row_177;
	}
	public String getRow_178() {
		return row_178;
	}
	public void setRow_178(String row_178) {
		this.row_178 = row_178;
	}
	public String getRow_179() {
		return row_179;
	}
	public void setRow_179(String row_179) {
		this.row_179 = row_179;
	}
	public String getRow_180() {
		return row_180;
	}
	public void setRow_180(String row_180) {
		this.row_180 = row_180;
	}
	public String getRow_181() {
		return row_181;
	}
	public void setRow_181(String row_181) {
		this.row_181 = row_181;
	}
	public String getRow_182() {
		return row_182;
	}
	public void setRow_182(String row_182) {
		this.row_182 = row_182;
	}
	public String getRow_183() {
		return row_183;
	}
	public void setRow_183(String row_183) {
		this.row_183 = row_183;
	}
	public String getRow_184() {
		return row_184;
	}
	public void setRow_184(String row_184) {
		this.row_184 = row_184;
	}
	public String getRow_185() {
		return row_185;
	}
	public void setRow_185(String row_185) {
		this.row_185 = row_185;
	}
	public String getRow_186() {
		return row_186;
	}
	public void setRow_186(String row_186) {
		this.row_186 = row_186;
	}
	public String getRow_187() {
		return row_187;
	}
	public void setRow_187(String row_187) {
		this.row_187 = row_187;
	}
	public String getRow_188() {
		return row_188;
	}
	public void setRow_188(String row_188) {
		this.row_188 = row_188;
	}
	public String getRow_189() {
		return row_189;
	}
	public void setRow_189(String row_189) {
		this.row_189 = row_189;
	}
	public String getRow_190() {
		return row_190;
	}
	public void setRow_190(String row_190) {
		this.row_190 = row_190;
	}
	public String getRow_191() {
		return row_191;
	}
	public void setRow_191(String row_191) {
		this.row_191 = row_191;
	}
	public String getRow_192() {
		return row_192;
	}
	public void setRow_192(String row_192) {
		this.row_192 = row_192;
	}
	public String getRow_193() {
		return row_193;
	}
	public void setRow_193(String row_193) {
		this.row_193 = row_193;
	}
	public String getRow_194() {
		return row_194;
	}
	public void setRow_194(String row_194) {
		this.row_194 = row_194;
	}
	public String getRow_195() {
		return row_195;
	}
	public void setRow_195(String row_195) {
		this.row_195 = row_195;
	}
	public String getRow_196() {
		return row_196;
	}
	public void setRow_196(String row_196) {
		this.row_196 = row_196;
	}
	public String getRow_197() {
		return row_197;
	}
	public void setRow_197(String row_197) {
		this.row_197 = row_197;
	}
	public String getRow_198() {
		return row_198;
	}
	public void setRow_198(String row_198) {
		this.row_198 = row_198;
	}
	public String getRow_199() {
		return row_199;
	}
	public void setRow_199(String row_199) {
		this.row_199 = row_199;
	}
	public String getRow_200() {
		return row_200;
	}
	public void setRow_200(String row_200) {
		this.row_200 = row_200;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getAuth_user() {
		return auth_user;
	}
	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public Date getAuth_time() {
		return auth_time;
	}
	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}
	public String getReport_version() {
		return report_version;
	}
	public void setReport_version(String report_version) {
		this.report_version = report_version;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public String getLevel_1() {
		return level_1;
	}
	public void setLevel_1(String level_1) {
		this.level_1 = level_1;
	}
	public String getLevel_2() {
		return level_2;
	}
	public void setLevel_2(String level_2) {
		this.level_2 = level_2;
	}
	public String getFiled_desc() {
		return filed_desc;
	}
	public void setFiled_desc(String filed_desc) {
		this.filed_desc = filed_desc;
	}
	public String getRow_201() {
		return row_201;
	}
	public void setRow_201(String row_201) {
		this.row_201 = row_201;
	}
	public String getRow_202() {
		return row_202;
	}
	public void setRow_202(String row_202) {
		this.row_202 = row_202;
	}
	public String getRow_203() {
		return row_203;
	}
	public void setRow_203(String row_203) {
		this.row_203 = row_203;
	}
	public String getRow_204() {
		return row_204;
	}
	public void setRow_204(String row_204) {
		this.row_204 = row_204;
	}
	public String getRow_205() {
		return row_205;
	}
	public void setRow_205(String row_205) {
		this.row_205 = row_205;
	}
	public String getRow_206() {
		return row_206;
	}
	public void setRow_206(String row_206) {
		this.row_206 = row_206;
	}
	public String getRow_207() {
		return row_207;
	}
	public void setRow_207(String row_207) {
		this.row_207 = row_207;
	}
	public String getRow_208() {
		return row_208;
	}
	public void setRow_208(String row_208) {
		this.row_208 = row_208;
	}
	public String getRow_209() {
		return row_209;
	}
	public void setRow_209(String row_209) {
		this.row_209 = row_209;
	}
	public String getRow_210() {
		return row_210;
	}
	public void setRow_210(String row_210) {
		this.row_210 = row_210;
	}
	public String getRow_211() {
		return row_211;
	}
	public void setRow_211(String row_211) {
		this.row_211 = row_211;
	}
	public String getRow_212() {
		return row_212;
	}
	public void setRow_212(String row_212) {
		this.row_212 = row_212;
	}
	public String getRow_213() {
		return row_213;
	}
	public void setRow_213(String row_213) {
		this.row_213 = row_213;
	}
	public String getRow_214() {
		return row_214;
	}
	public void setRow_214(String row_214) {
		this.row_214 = row_214;
	}
	public String getRow_215() {
		return row_215;
	}
	public void setRow_215(String row_215) {
		this.row_215 = row_215;
	}
	public String getRow_216() {
		return row_216;
	}
	public void setRow_216(String row_216) {
		this.row_216 = row_216;
	}
	public String getRow_217() {
		return row_217;
	}
	public void setRow_217(String row_217) {
		this.row_217 = row_217;
	}
	public String getRow_218() {
		return row_218;
	}
	public void setRow_218(String row_218) {
		this.row_218 = row_218;
	}
	public String getRow_219() {
		return row_219;
	}
	public void setRow_219(String row_219) {
		this.row_219 = row_219;
	}
	public String getRow_220() {
		return row_220;
	}
	public void setRow_220(String row_220) {
		this.row_220 = row_220;
	}
	public String getRow_221() {
		return row_221;
	}
	public void setRow_221(String row_221) {
		this.row_221 = row_221;
	}
	public String getRow_222() {
		return row_222;
	}
	public void setRow_222(String row_222) {
		this.row_222 = row_222;
	}
	public String getRow_223() {
		return row_223;
	}
	public void setRow_223(String row_223) {
		this.row_223 = row_223;
	}
	public String getRow_224() {
		return row_224;
	}
	public void setRow_224(String row_224) {
		this.row_224 = row_224;
	}
	public String getRow_225() {
		return row_225;
	}
	public void setRow_225(String row_225) {
		this.row_225 = row_225;
	}
	public String getRow_226() {
		return row_226;
	}
	public void setRow_226(String row_226) {
		this.row_226 = row_226;
	}
	public String getRow_227() {
		return row_227;
	}
	public void setRow_227(String row_227) {
		this.row_227 = row_227;
	}
	public String getRow_228() {
		return row_228;
	}
	public void setRow_228(String row_228) {
		this.row_228 = row_228;
	}
	public String getRow_229() {
		return row_229;
	}
	public void setRow_229(String row_229) {
		this.row_229 = row_229;
	}
	public String getRow_230() {
		return row_230;
	}
	public void setRow_230(String row_230) {
		this.row_230 = row_230;
	}
	public String getRow_231() {
		return row_231;
	}
	public void setRow_231(String row_231) {
		this.row_231 = row_231;
	}
	public String getRow_232() {
		return row_232;
	}
	public void setRow_232(String row_232) {
		this.row_232 = row_232;
	}
	public String getRow_233() {
		return row_233;
	}
	public void setRow_233(String row_233) {
		this.row_233 = row_233;
	}
	public String getRow_234() {
		return row_234;
	}
	public void setRow_234(String row_234) {
		this.row_234 = row_234;
	}
	public String getRow_235() {
		return row_235;
	}
	public void setRow_235(String row_235) {
		this.row_235 = row_235;
	}
	public String getRow_236() {
		return row_236;
	}
	public void setRow_236(String row_236) {
		this.row_236 = row_236;
	}
	public String getRow_237() {
		return row_237;
	}
	public void setRow_237(String row_237) {
		this.row_237 = row_237;
	}
	public String getRow_238() {
		return row_238;
	}
	public void setRow_238(String row_238) {
		this.row_238 = row_238;
	}
	public String getRow_239() {
		return row_239;
	}
	public void setRow_239(String row_239) {
		this.row_239 = row_239;
	}
	public String getRow_240() {
		return row_240;
	}
	public void setRow_240(String row_240) {
		this.row_240 = row_240;
	}
	public String getRow_241() {
		return row_241;
	}
	public void setRow_241(String row_241) {
		this.row_241 = row_241;
	}
	public String getRow_242() {
		return row_242;
	}
	public void setRow_242(String row_242) {
		this.row_242 = row_242;
	}
	public String getRow_243() {
		return row_243;
	}
	public void setRow_243(String row_243) {
		this.row_243 = row_243;
	}
	public String getRow_244() {
		return row_244;
	}
	public void setRow_244(String row_244) {
		this.row_244 = row_244;
	}
	public String getRow_245() {
		return row_245;
	}
	public void setRow_245(String row_245) {
		this.row_245 = row_245;
	}
	public String getRow_246() {
		return row_246;
	}
	public void setRow_246(String row_246) {
		this.row_246 = row_246;
	}
	public String getRow_247() {
		return row_247;
	}
	public void setRow_247(String row_247) {
		this.row_247 = row_247;
	}
	public String getRow_248() {
		return row_248;
	}
	public void setRow_248(String row_248) {
		this.row_248 = row_248;
	}
	public String getRow_249() {
		return row_249;
	}
	public void setRow_249(String row_249) {
		this.row_249 = row_249;
	}
	public String getRow_250() {
		return row_250;
	}
	public void setRow_250(String row_250) {
		this.row_250 = row_250;
	}
	public String getRow_251() {
		return row_251;
	}
	public void setRow_251(String row_251) {
		this.row_251 = row_251;
	}
	public String getRow_252() {
		return row_252;
	}
	public void setRow_252(String row_252) {
		this.row_252 = row_252;
	}
	 
	public BRF_REF_CODE_ENTITY() {
		super();
	
	}

	

}
